package com.example.traffic.controller;

import com.example.traffic.entity.Visit;
import com.example.traffic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/app")
public class VisitController {

    @Autowired
    private VisitService visitService;

    public void setVisitService(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping(value = "/visit", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map addVisitAndGetDailyTraffic(@RequestParam("userId") Long userId, @RequestParam("pageId") Long pageId) {
        LocalDate now = LocalDate.now();
        Visit visit = new Visit(userId, pageId, now);
        visitService.save(visit);
        Map map = new HashMap();
        map.put("visitsCount", visitService.countAllByLocalDate(now));
        map.put("usersCount", visitService.countAllUsersByLocalDate(now));
        return map;
    }

    @GetMapping(value = "/traffic", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map getTrafficForPeriod(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from
            , @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
        Map map = new HashMap();
        map.put("visitsCount", visitService.countAllByLocalDateBetween(from, to));
        map.put("usersCount", visitService.countAllUsersByLocalDateBetween(from, to));
        map.put("regularUsersCount", visitService.countAllRegularUsers(from, to));
        return map;
    }
}
