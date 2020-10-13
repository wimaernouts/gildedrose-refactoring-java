package com.gildedrose;

import com.gildedrose.legacy.Item;
import com.gildedrose.quality.QualityType;

import static com.gildedrose.ItemName.*;
import static com.gildedrose.quality.QualityType.BACKSTAGE;
import static com.gildedrose.quality.QualityType.DECREASE_DOUBLE;

//TODO 20 After validation -> create ItemWrapperFactory
public class ItemWrapperFactory {


    public static ItemWrapper createItemWrapper(Item item) {
        return new ItemWrapper(item, determineQualityType(item.name));
    }

    private static QualityType determineQualityType(String name) {
        switch (name) {
            case VEST:
            case ELEXIR:
                return QualityType.DECREASE;
            case AGED_BRIE: return QualityType.INCREASE;
            case SULFURAS: return QualityType.FIXED;
            case BACKSTAGE_PASS: return BACKSTAGE;
            case CONJURED: return DECREASE_DOUBLE;
            default: throw new ItemNotFoundException(String.format("Item %s is not known in GildedRose", name));

        }
    }
}
