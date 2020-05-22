package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.google.common.collect.Sets;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> products = new ArrayList<Product>();

        products.add(new Product("p1"));
        products.add(new Product("p2"));
        products.add(new Product("p3"));
        products.add(new Product("p4"));

        ArrayList<Combination> combinations = getCombinations(products);

        for (Combination combination : combinations) {
            for (Product product : combination.getProducts()) {
                System.out.print(product.getName() + " ");
            }
            System.out.println();
        }

    }

    public static ArrayList<Combination> getCombinations(ArrayList<Product> products) {
        ArrayList<Combination> combinations = new ArrayList<Combination>();
        Set<Product> productsSet = new HashSet<Product>(products);
        Set<Set<Product>> combinationsSet = Sets.powerSet(productsSet);
        Iterator<Set<Product>> combinationsIterator = combinationsSet.iterator();
        while (combinationsIterator.hasNext()) {
            ArrayList<Product> productsList = new ArrayList<Product>(combinationsIterator.next());
            Combination combination = new Combination(productsList);
            combinations.add(combination);
        }
        return combinations;
    }
}