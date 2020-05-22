Collection<Item> reduced = data.stream()
    .collect(
        Collectors.groupingBy(Item::getunitPrice),
        Collectors.reducing((i, j) -> {
            int productQuantityInStock = Integer.parseInt(i.getpurchasedQuantity()) + Integer.parseInt(j).getpurchasedQuantity());
            i.setProductInStock(String.valueOf(productQuantityInStock));
            return i;
        })
    .values();