package com.gildedrose;

class GildedRose {
    Item[] items;

    GildedRose(Item[] items) {
        this.items = items;
    }

    void updateQuality() {
        for (Item item : items) {
            doUpdate(item);
        }
    }

    private void doUpdate(Item item) {
        switch (item.name) {
            case "Aged Brie":
                agedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                backstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Conjured Mana Cake":
                basicAndConjured(item, 2);
                break;
            default:
                basicAndConjured(item, 1);
        }
    }

    private void basicAndConjured(Item item, int i) {
        qualityLoss(item, i);

        endOfDay(item);

        outOfDate(item, i);
    }

    private void backstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality += 1;

            if (item.sellIn < 11) {
                plusQuality(item, item.quality, 50, item.quality + 1);
            }

            if (item.sellIn < 6) {
                plusQuality(item, item.quality, 50, item.quality + 1);
            }
        }

        endOfDay(item);

        plusQuality(item, item.sellIn, 0, 0);
    }

    private void agedBrie(Item item) {
        plusQuality(item, item.quality, 50, item.quality + 1);

        endOfDay(item);

        if (item.sellIn < 0) {
            plusQuality(item, item.quality, 50, item.quality + 1);
        }
    }
    private void qualityLoss(Item item, int i) {
        if (item.quality > 0) {
            item.quality -= i;
        }
    }

    private void endOfDay(Item item) {
        item.sellIn -= 1;
    }

    private void outOfDate(Item item, int a) {
        if (item.sellIn < 0) {
            qualityLoss(item, a);
        }
    }

    private void plusQuality(Item item, int quality, int i, int i2) {
        if (quality < i) {
            item.quality = i2;

        }
    }


}