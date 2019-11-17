package com.gildedrose;

public class ItemPattern extends Item{
    public ItemPattern(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    static void qualityLoss(Item item, int i) {
        if (item.quality > 0) {
            item.quality = item.quality - i;
        }
    }

    static void endOfDay(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    static void outOfDate(Item item, int a) {
        if (item.sellIn < 0) {
            qualityLoss(item, a);
        }
    }

    static void plusQuality(Item item, int quality, int i, int i2) {
        if (quality < i) {
            item.quality = i2;

        }
    }
}
