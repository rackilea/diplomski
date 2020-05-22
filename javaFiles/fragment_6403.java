package model;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class App {

    public static void main(String[] args) {
        Map<String, Shop> shops = new HashMap<String, Shop>();
        Shop s1 = new Shop(1, "Apus Drugstore");
        Shop s2 = new Shop(2, "DM");
        Shop s3 = new Shop(3, "Kaufhof");
        Shop s4 = new Shop(4, "Moes Traverne");

        shops.put("one", s3);
        shops.put("two", s4);
        shops.put("three", s1);
        shops.put("four", s2);

        for(Shop s : shops.values()) {
            System.out.println(s.getName());
        }
        ShopComparator sc = new ShopComparator();
        TreeSet<Shop> sortedShops = new TreeSet<>(sc);

        sortedShops.addAll(shops.values());

        for(Shop s : sortedShops) {
            System.out.println(s.getName());
        }
    }

}