package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.quality.QualityType.FIXED;
import static org.assertj.core.api.Assertions.assertThat;

//TODO 7 wrapper met aftesten van 1 - 1 relatie met item
class ItemWrapperTest {

    @Test
    void getName() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4,6);

        assertThat(itemWrapper.getName()).isEqualTo("foo");
    }

    @Test
    void getSellIn() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4,6);

        assertThat(itemWrapper.getSellIn()).isEqualTo(4);
    }

    @Test
    void setSellIn() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4,6);
        itemWrapper.setSellIn(20);

        assertThat(itemWrapper.getSellIn()).isEqualTo(20);
    }

    @Test
    void getQuality() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4,6);

        assertThat(itemWrapper.getQuality()).isEqualTo(6);
    }

    @Test
    void setQuality() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4,6);
        itemWrapper.setQuality(7);

        assertThat(itemWrapper.getQuality()).isEqualTo(7);
    }

    @Test
    void updateQuality_default_decrease_quality() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4, 7);

        itemWrapper.updateItem();

        assertThat(itemWrapper.getQuality()).isEqualTo(6);
    }

    //TODO 14 sellIn decrease
    @Test
    void updateQuality_sellIn_decrease() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4, 7);

        itemWrapper.updateItem();

        assertThat(itemWrapper.getSellIn()).isEqualTo(3);
    }

    @Test
    void updateQuality_sellIn_fixed() {
        ItemWrapper itemWrapper = new ItemWrapper("foo", 4, 7, FIXED);

        itemWrapper.updateItem();

        assertThat(itemWrapper.getSellIn()).isEqualTo(4);
    }
}