package com.example.tvseriestesting.service;

import com.example.tvseriestesting.entity.TvSeries;
import com.example.tvseriestesting.repository.TvSeriesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TvSeriesService {

    private final TvSeriesRepository tvSeriesRepository;

    public TvSeriesService(TvSeriesRepository tvSeriesRepository) {
        this.tvSeriesRepository = tvSeriesRepository;
    }

    public List<TvSeries> findAllTvSeries() {
        return tvSeriesRepository.findAll();
    }

    public TvSeries addTvSeries(TvSeries tvSeries) {
        return tvSeriesRepository.save(tvSeries);
    }
}
