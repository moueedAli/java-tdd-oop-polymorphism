package com.booleanuk.core;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    List<Item> items = new ArrayList<>();

    public void add(Item item) {
        this.items.add(item);
    }

    public int getTotal() {
        int total = 0;

        for (Item it : this.items) {
            total += it.getPrice();
        }

        return total;
    }

    public boolean isInBasket(String name) {
        for (Item it : this.items) {
            if (it.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
