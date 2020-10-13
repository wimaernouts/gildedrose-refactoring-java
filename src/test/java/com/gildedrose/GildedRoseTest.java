package com.gildedrose;

import com.gildedrose.legacy.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class GildedRoseTest {

    @Test
    //TODO 3 -> rename test
    void itemName() {
        //TODO 2 array of list -> immutable store with fixed products?
        GildedRose app = new GildedRose(createSingleArrayOfItem("Aged Brie", 0, 0));

        app.updateItems();
        //TODO 1 -> Fix test assertEquals("fixme", app.items[0].getName());
        //TODO 1 remark: Readability -> assertThat().isEqualTo AssertJ -> maven
        //TODO 3 -> fix test (nog steeds een zinloze test)
        //assertThat(app.items[0].getName()).isEqualTo("foo");
        assertThat(app.getItem(0).getName()).isEqualTo("Aged Brie");
    }

    //TODO 4-> start with new tests
    @Test
    void getItem_encapsulation() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.AGED_BRIE, 0, 0));

        ItemWrapper item = app.getItem(0);

        assertThat(item).isNotNull();
    }

    //TODO 5 Optional or not
    @Test
    void getItem_notExisting() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 0, 0));

        assertThatExceptionOfType(ItemNotFoundException.class).isThrownBy(() -> assertThat(app.getItem(1)));
    }

    //TODO 8 business rule regular products -> start
    @Test
    @DisplayName("At the end of each day our system lowers both values for sellIn")
    void regular_sellIn_lowers_by_one() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 1, 7));

        app.updateItems();

        assertThat(app.getItem(0).getSellIn()).isEqualTo(0);
    }

    @Test
    @DisplayName("At the end of each day our system lowers both values for quality")
    void regular_quality_lowers_by_one() {
        GildedRose app = new GildedRose((createSingleArrayOfItem(ItemName.ELEXIR, 1, 7)));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(6);
    }

    @Test
    @DisplayName("Once the sell by date has passed, Quality degrades twice as fast")
    void sellDatePast_degrades_twice() {
        GildedRose app = new GildedRose((createSingleArrayOfItem(ItemName.ELEXIR, 0, 7)));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(5);
    }

    @Test
    @DisplayName("The Quality of an item is never negative")
    void quality_never_negative() {
        GildedRose app = new GildedRose((createSingleArrayOfItem(ItemName.ELEXIR, 8, 0)));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(0);
    }

    @Test
    @DisplayName("\"Aged Brie\" actually increases in Quality the older it gets")
    void agedBrie_quality_rises() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.AGED_BRIE, 2, 10));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(11);
    }

    @Test
    @DisplayName("The Quality of an item is never more than 50")
    void agedBrie_quality_max_50() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.AGED_BRIE, 2, 50));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(50);
    }

    @Test
    @DisplayName("\"Sulfuras\", being a legendary item, never has to be sold or decreases in Quality")
    void sulfuras_never_sold() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.SULFURAS, 2, 20));

        app.updateItems();

        assertThat(app.getItem(0).getSellIn()).isEqualTo(2);
        assertThat(app.getItem(0).getQuality()).isEqualTo(20);
    }

    @Test
    @DisplayName("\"Backstage passes\", increases in Quality > 10 days sellIn")
    void backstage_passes_increase() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 12, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(21);
    }

    @Test
    @DisplayName("\"Backstage passes\", increases by 2 in Quality = 10 days sellIn")
    void backstage_passes_increase_2_equals_maxDays() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 10, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(22);
    }

    @Test
    @DisplayName("\"Backstage passes\", increases by 2 in Quality 5 < x < 10 days sellIn")
    void backstage_passes_increase_2_equals_betweenDays() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 6, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(22);
    }

    @Test
    @DisplayName("\"Backstage passes\", increases by 3 in Quality = 5 days sellIn")
    void backstage_passes_increase_3_equals_max() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 5, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(23);
    }

    @Test
    @DisplayName("\"Backstage passes\", increases by 3 in Quality < 5 days sellIn")
    void backstage_passes_increase_3_lower_max() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 1, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(23);
    }

    @Test
    @DisplayName("\"Backstage passes\", Quality drops to 0 after the concert")
    void backstage_passes_quality_drops_0() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.BACKSTAGE_PASS, 0, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(0);
    }
    //TODO 8 business rule regular products -> stop

    //TODO 15 conjured
    @Test
    void conjured_item() {
        GildedRose app = new GildedRose(createSingleArrayOfItem(ItemName.CONJURED, 5, 20));

        app.updateItems();

        assertThat(app.getItem(0).getQuality()).isEqualTo(18);
        assertThat(app.getItem(0).getSellIn()).isEqualTo(4);
    }

    //TODO 22 readability to create an Item
    private Item[] createSingleArrayOfItem(String itemName, int sellIn, int quality) {
        return new Item[]{new Item(itemName, sellIn, quality)};
    }
}
