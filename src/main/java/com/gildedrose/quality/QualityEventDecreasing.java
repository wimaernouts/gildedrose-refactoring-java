package com.gildedrose.quality;

public class QualityEventDecreasing implements QualityEvent {

    private static final int MIN_QUALITY = 0;

    //TODO 16 speedFactor
    private final int factor;

    public QualityEventDecreasing(int factor) {
        this.factor = factor;
    }

    public QualityEventDecreasing() {
        this(1);
    }

    @Override
    public int changeQuality(int sellIn, int quality) {
        return quality > MIN_QUALITY
                ? quality-getQuantityDecrease(sellIn)
                : MIN_QUALITY;
    }

    private int getQuantityDecrease(int sellIn) {
        return (sellIn != 0 ? 1 : 2) * factor;
    }
}
