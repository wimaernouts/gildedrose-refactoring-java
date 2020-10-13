package com.gildedrose.quality;

import org.junit.jupiter.api.Test;

import static com.gildedrose.quality.QualityType.DECREASE;
import static com.gildedrose.quality.QualityType.INCREASE;
import static org.assertj.core.api.Assertions.assertThat;

class QualityTypeTest {

    @Test
    void QualityEventDecreasing() {
        assertThat(DECREASE.getInstance()).isInstanceOf(QualityEventDecreasing.class);
    }

    @Test
    void QualityEventIncreasing() {
        assertThat(INCREASE.getInstance()).isInstanceOf(QualityEventIncreasing.class);
    }

}