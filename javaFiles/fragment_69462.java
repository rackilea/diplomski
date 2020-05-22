List<Product> productList = Arrays.asList(
        new Product("MILK", Product.PurchaseType.ONLINE, "3.99"),
        new Product("MILK", Product.PurchaseType.ONLINE, "3.99"),
        new Product("MILK", Product.PurchaseType.INSTORE, "4.95"),
        new Product("BREAD", Product.PurchaseType.INSTORE, "7.48")
);

Map<String, ProductResult> result = productList.stream()
        .collect(Collectors.groupingBy(Product::getCode,
                    Collector.of(ProductResult::new,
                                 ProductResult::add,
                                 ProductResult::merge,
                                 Characteristics.UNORDERED)));
result.entrySet().forEach(System.out::println);