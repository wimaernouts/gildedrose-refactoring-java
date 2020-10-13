package com.gildedrose;

import com.gildedrose.legacy.Item;
import com.gildedrose.quality.QualityType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ItemWrapperFactoryTest {

    @Test
    void createVest() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("+5 Dexterity Vest",4,5));

        assertThat(wrapper).isNotNull();
    }

    @Test
    void createVest_name() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("+5 Dexterity Vest",4,5));

        assertThat(wrapper.getName()).isEqualTo("+5 Dexterity Vest");
    }

    @Test
    void createVest_sellin() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("+5 Dexterity Vest",4,5));

        assertThat(wrapper.getSellIn()).isEqualTo(4);
    }

    @Test
    void createVest_quality() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("+5 Dexterity Vest",4,5));

        assertThat(wrapper.getQuality()).isEqualTo(5);
    }

    @Test
    void createVest_qualityType() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("+5 Dexterity Vest",4,5));

        assertThat(wrapper.getQualityType()).isEqualTo(QualityType.DECREASE);
    }

    @Test
    void createAgedBrie_qualityType() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("Aged Brie",4,5));

        assertThat(wrapper.getQualityType()).isEqualTo(QualityType.INCREASE);
    }

    @Test
    void createElexir_qualityType() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("Elixir of the Mongoose",4,5));

        assertThat(wrapper.getQualityType()).isEqualTo(QualityType.DECREASE);
    }

    @Test
    void createSulfuras_qualityType() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("Sulfuras, Hand of Ragnaros",4,5));

        assertThat(wrapper.getQualityType()).isEqualTo(QualityType.FIXED);
    }

    @Test
    void createBackstage_qualityType() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("Backstage passes to a TAFKAL80ETC concert",4,5));

        assertThat(wrapper.getQualityType()).isEqualTo(QualityType.BACKSTAGE);
    }

    @Test
    void createConjured_qualityType() {
        ItemWrapper wrapper = ItemWrapperFactory.createItemWrapper(new Item("Conjured Mana Cake",4,5));

        assertThat(wrapper.getQualityType()).isEqualTo(QualityType.DECREASE_DOUBLE);
    }
}