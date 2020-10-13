package com.gildedrose.quality;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QualityEventIncreasingTest {

    //TODO 9 qualityEvent decrease / increase
    @Test
    void qualityIncreases_1() {
        QualityEvent qualityEvent = new QualityEventIncreasing();

        assertThat(qualityEvent.changeQuality(15, 4)).isEqualTo(5);
    }

    //TODO 10 MAX_INCREASE
    @Test
    void qualityIncreases_max_reached() {
        QualityEvent qualityEvent = new QualityEventIncreasing();

        assertThat(qualityEvent.changeQuality(16, 51)).isEqualTo(50);
    }

}