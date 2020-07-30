package com.example.traffic.service;

import com.example.traffic.entity.Visit;

import java.time.LocalDate;

public interface VisitService {
    Visit save(Visit visit);

    Long countAllByLocalDate(LocalDate localDate);

    Long countAllUsersByLocalDate(LocalDate localDate);

    Long countAllByLocalDateBetween(LocalDate from, LocalDate to);

    Long countAllUsersByLocalDateBetween(LocalDate from, LocalDate to);

    Long countAllRegularUsers(LocalDate from, LocalDate to);
}
