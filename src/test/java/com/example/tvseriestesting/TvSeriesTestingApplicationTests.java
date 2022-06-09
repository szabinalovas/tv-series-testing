package com.example.tvseriestesting;

import com.example.tvseriestesting.entity.TvSeries;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TvSeriesTestingApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    private String url = "/tv-series";

    @Test
    void testGetAll() {
        TvSeries[] expectedArr = {new TvSeries("Breaking bad", "everybody", 5L),
                new TvSeries("Pumukli", "everybody", 3L)};

        for (TvSeries tvSeries : expectedArr) {
            postTvSeriesToUrl(tvSeries, url);
        }

        ResponseEntity<TvSeries[]> responseEntity = testRestTemplate.getForEntity(url, TvSeries[].class);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        assertArraysHasSameElements(expectedArr, responseEntity.getBody());
    }

    private void postTvSeriesToUrl(TvSeries tvSeries, String url) {
        HttpEntity<TvSeries> httpEntity = createHttpEntity(tvSeries);
        testRestTemplate.postForEntity(url, httpEntity, String.class);
    }

    private HttpEntity<TvSeries> createHttpEntity(TvSeries tvSeries) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(tvSeries, httpHeaders);
    }

    private void assertArraysHasSameElements(TvSeries[] expectedArr, TvSeries[] actualArr) {
        List<TvSeries> expected = Arrays.asList(expectedArr);
        List<TvSeries> actual = Arrays.asList(actualArr);
        assertTrue(expected.size() == actual.size() && expected.containsAll(actual) && actual.containsAll(expected));
    }


}
