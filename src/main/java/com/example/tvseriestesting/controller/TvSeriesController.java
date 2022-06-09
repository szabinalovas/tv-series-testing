package com.example.tvseriestesting.controller;

import com.example.tvseriestesting.entity.TvSeries;
import com.example.tvseriestesting.service.TvSeriesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tv-series")
public class TvSeriesController {

    private final TvSeriesService tvSeriesService;

    public TvSeriesController(TvSeriesService tvSeriesService) {
        this.tvSeriesService = tvSeriesService;
    }

    @GetMapping
    public List<TvSeries> findAllTvSeries() {
        return tvSeriesService.findAllTvSeries();
    }

    @PostMapping
    public TvSeries addTvSeries(@RequestBody TvSeries tvSeries) {
        return tvSeriesService.addTvSeries(tvSeries);
    }
}
