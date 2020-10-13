package com.gildedrose.quality;

//TODO 12 Enum met Automatic QualityEvent
public enum QualityType {
    DECREASE {
        @Override
        public QualityEvent getInstance() {
            return new QualityEventDecreasing(1);
        }
    },
    DECREASE_DOUBLE {
        @Override
        public QualityEvent getInstance() {
            return new QualityEventDecreasing(2);
        }
    },
    INCREASE {
        @Override
        public QualityEvent getInstance() {
            return new QualityEventIncreasing();
        }
    },
    FIXED {
        //TODO 13 -> lambda
        @Override
        public QualityEvent getInstance() {
            return (sellIn, quality) -> quality;
        }
    },
    BACKSTAGE {
        @Override
        public QualityEvent getInstance() {
            return new QualityEventBackstage();
        }
    };

    public abstract QualityEvent getInstance();
}
