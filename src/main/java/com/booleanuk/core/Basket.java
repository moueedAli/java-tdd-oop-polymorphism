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

        for (Item i : this.items) {
            total += i.getPrice();
        }

        return total;
    }

    public boolean isInBasket(String name) {
        for (Item i : this.items) {
            if (i.getName().equals(name)) {
                return true;
            }
        }

        return false;
    }
}
