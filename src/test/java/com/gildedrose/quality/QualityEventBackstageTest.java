package com.gildedrose.quality;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QualityEventBackstageTest {

    @Test
    @DisplayName("increases in Quality > 10 days sellIn")
    void QualityEventBackstage() {
        QualityEventBackstage backstage = new QualityEventBackstage();

        assertThat(backstage.changeQuality(11, 23)).isEqualTo(24);
    }

    @Test
    @DisplayName("increases in Quality > 5 days sellIn")
    void QualityEventBackstage_second_limit() {
        QualityEventBackstage backstage = new QualityEventBackstage();

        assertThat(backstage.changeQuality(10, 10)).isEqualTo(12);
    }

    @Test
    @DisplayName("increases in Quality <= 5 days sellIn")
    void QualityEventBackstage_last_limit() {
        QualityEventBackstage backstage = new QualityEventBackstage();

        assertThat(backstage.changeQuality(5, 10)).isEqualTo(13);
    }

    @Test
    @DisplayName("sellIn date passed")
    void QualityEventBackstage_sellIn_passed() {
        QualityEventBackstage backstage = new QualityEventBackstage();

        assertThat(backstage.changeQuality(0, 10)).isEqualTo(0);
    }
}