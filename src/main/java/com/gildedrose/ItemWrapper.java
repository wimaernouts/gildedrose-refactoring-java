package com.gildedrose;

import com.gildedrose.legacy.Item;
import com.gildedrose.quality.QualityType;

import static com.gildedrose.quality.QualityType.FIXED;

public class ItemWrapper {
    private final Item item;
    private final QualityType qualityType;

    //TODO 17 hide legacy usage
    public ItemWrapper(String name, int sellIn, int quality) {
        this(name, sellIn, quality, QualityType.DECREASE);
    }

    //Create factory to determine quality by name
    public ItemWrapper(Item item, QualityType qualityType) {
        this(item.name, item.sellIn, item.quality, qualityType);
    }

    public ItemWrapper(String name, int sellIn, int quality, QualityType qualityType) {
        this.item = new Item(name, sellIn, quality);
        this.qualityType = qualityType;
    }

    public String getName() {
        return item.name;
    }

    public int getSellIn() {
        return item.sellIn;
    }

    public void setSellIn(int sellIn) {
        item.sellIn = sellIn;
    }

    public int getQuality() {
        return item.quality;
    }

    public void setQuality(int quality) {
        item.quality = quality;
    }

    public QualityType getQualityType() {
        return qualityType;
    }

    public void updateItem() {
        updateQuality();
        updateSellIn();
    }

    private void updateQuality() {
        setQuality(qualityType.getInstance().changeQuality(getSellIn(), getQuality()));
    }

    private void updateSellIn() {
        if (FIXED != qualityType) {
            setSellIn(getSellIn() - 1);
        }
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
