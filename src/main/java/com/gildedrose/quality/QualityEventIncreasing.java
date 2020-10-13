package com.gildedrose.quality;

public class QualityEventIncreasing implements QualityEvent {

    private final static int MAX_QUALITY = 50;

    @Override
    public int changeQuality(int sellIn, int quality) {
        return quality < MAX_QUALITY
                ? quality+1
                : MAX_QUALITY;
    }
}
