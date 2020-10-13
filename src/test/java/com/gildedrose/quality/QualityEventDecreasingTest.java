package com.gildedrose.quality;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QualityEventDecreasingTest {

    //TODO 9 qualityEvent decrease / increase
    @Test
    void checkRegularQuality() {
        QualityEvent regular = new QualityEventDecreasing();

        assertThat(regular.changeQuality(10,5)).isEqualTo(4);
    }

    //TODO 11
    @Test
    void checkRegularQuality_minimum_quality() {
        QualityEvent regular = new QualityEventDecreasing();

        assertThat(regular.changeQuality(7,0)).isEqualTo(0);
    }

    @Test
    void checkRegularQuality_sellIn_passed_twice_as_fast() {
        QualityEvent regular = new QualityEventDecreasing();

        assertThat(regular.changeQuality(0,8)).isEqualTo(6);
    }

    @Test
    void upgradeSpeedFactor() {
        QualityEvent regular = new QualityEventDecreasing(2);

        assertThat(regular.changeQuality(4, 9)).isEqualTo(7);
    }
}