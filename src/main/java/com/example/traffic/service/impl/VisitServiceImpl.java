package com.example.traffic.service.impl;

import com.example.traffic.entity.Visit;
import com.example.traffic.repository.VisitRepository;
import com.example.traffic.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class VisitServiceImpl implements VisitService {

    @Autowired
    VisitRepository visitRepository;

    public void setVisitRepository(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }

    public Long countAllByLocalDate(LocalDate localDate) {
        return visitRepository.countAllVisitsByLocalDate(localDate);
    }

    public Long countAllUsersByLocalDate(LocalDate localDate) {
        return visitRepository.countAllUsersByLocalDate(localDate);
    }

    public Long countAllByLocalDateBetween(LocalDate from, LocalDate to) {
        return visitRepository.countAllVisitsByLocalDateBetween(from, to);
    }

    public Long countAllUsersByLocalDateBetween(LocalDate from, LocalDate to) {
        return visitRepository.countAllUsersByLocalDateBetween(from, to);
    }

    public Long countAllRegularUsers(LocalDate from, LocalDate to) {
        return visitRepository.countAllRegularUsers(from, to);
    }
}
