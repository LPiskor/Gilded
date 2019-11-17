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
                AgedBrie(item);
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                BackstagePasses(item);
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            case "Conjured Mana Cake":
                BasicAndConjured(item, 2);
                break;
            default:
                BasicAndConjured(item, 1);
        }
    }

    private void BasicAndConjured(Item item, int i) {
        ItemPattern.qualityLoss(item, i);
        ItemPattern.endOfDay(item);
        ItemPattern.outOfDate(item, i);
    }

    private void BackstagePasses(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                ItemPattern.plusQuality(item, item.quality, 50, item.quality + 1);
            }

            if (item.sellIn < 6) {
                ItemPattern.plusQuality(item, item.quality, 50, item.quality + 1);
            }
        }

        ItemPattern.endOfDay(item);

        ItemPattern.plusQuality(item, item.sellIn, 0, 0);
    }

    private void AgedBrie(Item item) {
        ItemPattern.plusQuality(item, item.quality, 50, item.quality + 1);

        ItemPattern.endOfDay(item);

        if (item.sellIn < 0) {
            ItemPattern.plusQuality(item, item.quality, 50, item.quality + 1);
        }
    }

}