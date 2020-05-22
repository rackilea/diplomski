List<Product> products = // ...
List<Product> filterSortedProdycts = 
    products.stream()
            .filter(p -> p.getType() == ProductType.BANANA)  // only keep BANANA
            .sorted(Comparator.comparing(Product::getPrice)) // sort by price
            .collect(Collectors.toList());