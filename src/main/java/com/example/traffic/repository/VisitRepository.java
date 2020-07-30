package com.example.traffic.repository;

import com.example.traffic.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {
    Visit save(Visit visit);

//    @Query(value = "SELECT count(v) FROM Visit v WHERE v.localDate = :date")
    Long countAllVisitsByLocalDate(LocalDate date);

    @Query(value = "SELECT count(*) FROM (SELECT count(*) FROM visit as v WHERE v.local_date = :date GROUP BY v.user_id) as unicuser", nativeQuery = true)
    Long countAllUsersByLocalDate(LocalDate date);

    @Query(value = "SELECT count(v) FROM Visit v WHERE v.localDate >= :from and  v.localDate <= :to")
    Long countAllVisitsByLocalDateBetween(LocalDate from, LocalDate to);

    @Query(value = "SELECT count(*) FROM (SELECT count(*) FROM Visit as v WHERE v.local_date >= :from and  v.local_date <= :to GROUP BY v.user_id) as nomatter", nativeQuery = true)
    Long countAllUsersByLocalDateBetween(LocalDate from, LocalDate to);

    @Query(value = "SELECT count(*) FROM (SELECT count(*) FROM visit as v WHERE (v.local_date >= :from and  v.local_date <= :to) " +
            "GROUP BY v.user_id HAVING count(v.page_id) >= 10) as upc", nativeQuery = true)
    Long countAllRegularUsers(LocalDate from, LocalDate to);
}
