package com.gildedrose;

import com.gildedrose.legacy.Item;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    //TODO 6 private final
    private final List<ItemWrapper> items;

    public GildedRose(List<ItemWrapper> items) {
        this.items = items;
    }

    public GildedRose(Item[] items) {
        this.items = Arrays.stream(items).map(ItemWrapperFactory::createItemWrapper)
                        .collect(Collectors.toList());
    }

    //TODO may not change interface of GildedRose
    /**
    public GildedRose(ItemWrapper item) {
        this.items = Collections.singletonList(item);
    }*/

    //TODO 18 DELETE item usage
    /**
    public GildedRose(Item item, QualityType qualityType) {
        this.items = Collections.singletonList(new ItemWrapper(item, qualityType));
    }

    public GildedRose(Item item) {
        this.items = Collections.singletonList(new ItemWrapper(item));
    }*/

    public void updateItems() {
        //TODO 9 kleinere methods forEach
        items.forEach(ItemWrapper::updateItem);
        //executeOldStyle();
    }

    private void executeOldStyle() {
        for (ItemWrapper item : items) {
            if (!item.getName().equals("Aged Brie") && !item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.getQuality() > 0) {
                    if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                        item.setQuality(item.getQuality() - 1);
                    }
                }
            } else {
                if (item.getQuality() < 50) {
                    item.setQuality(item.getQuality() + 1);

                    if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.getSellIn() < 11) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }

                        if (item.getSellIn() < 6) {
                            if (item.getQuality() < 50) {
                                item.setQuality(item.getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                item.setSellIn(item.getSellIn() - 1);
            }

            if (item.getSellIn() < 0) {
                if (!item.getName().equals("Aged Brie")) {
                    if (!item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.getQuality() > 0) {
                            if (!item.getName().equals("Sulfuras, Hand of Ragnaros")) {
                                item.setQuality(item.getQuality() - 1);
                            }
                        }
                    } else {
                        item.setQuality(item.getQuality() - item.getQuality());
                    }
                } else {
                    if (item.getQuality() < 50) {
                        item.setQuality(item.getQuality() + 1);
                    }
                }
            }
        }
    }

    public ItemWrapper getItem(int index) {
        try {
            return items.get(index);
        } catch (IndexOutOfBoundsException e) {
            throw new ItemNotFoundException(String.format("Item not found in GildedRose with index %d", index));
        }
    }
}