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
                Aged_Brie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                Backstage_Passes(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Conjured Mana Cake":
                Basic_And_Conjured(item, 2);
                break;
            default:
                Basic_And_Conjured(item, 1);
        }
    }

    private void Basic_And_Conjured(Item item, int i) {
        qualityLoss(item, i);

        endOfDay(item);

        outOfDate(item, i);
    }

    private void Backstage_Passes(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

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

    private void Aged_Brie(Item item) {
        plusQuality(item, item.quality, 50, item.quality + 1);

        endOfDay(item);

        if (item.sellIn < 0) {
            plusQuality(item, item.quality, 50, item.quality + 1);
        }
    }

    private void qualityLoss(Item item, int i) {
        if (item.quality > 0) {
            item.quality = item.quality - i;
        }
    }

    private void endOfDay(Item item) {
        item.sellIn = item.sellIn - 1;
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