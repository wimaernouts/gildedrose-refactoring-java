package com.gildedrose.quality;

//TODO 14
public class QualityEventBackstage implements QualityEvent {

    private static final int FIRST_LIMIT = 10;
    private static final int SECOND_LIMIT = 5;

    @Override
    public int changeQuality(int sellIn, int quality) {
        if (sellIn == 0) {
            return 0;
        }
        return isAfterLimit(sellIn, FIRST_LIMIT)
                ? add(1, quality)
                : isAfterLimit(sellIn, SECOND_LIMIT)
                    ? add(2, quality) :  add(3, quality);
    }

    private boolean isAfterLimit(int sellIn, int limit) {
        return sellIn > limit;
    }

    private int add(int value, int quality) {
        return quality + value;
    }
}
