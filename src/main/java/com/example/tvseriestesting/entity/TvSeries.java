package com.example.tvseriestesting.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TvSeries {

    @Id
    private String title;
    private String genre;
    private Long numberOfSeasons;

}
