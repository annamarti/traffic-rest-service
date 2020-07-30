package com.example.traffic.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private Long pageId;

    @Column
//    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate localDate;

    public Visit() {
    }


    public Visit(Long userId, Long pageId, LocalDate localDate) {
        this.userId = userId;
        this.pageId = pageId;
        this.localDate = localDate;
    }
}
