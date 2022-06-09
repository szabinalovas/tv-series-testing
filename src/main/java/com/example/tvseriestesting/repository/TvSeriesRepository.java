package com.example.tvseriestesting.repository;

import com.example.tvseriestesting.entity.TvSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TvSeriesRepository extends JpaRepository<TvSeries, String> {
}
