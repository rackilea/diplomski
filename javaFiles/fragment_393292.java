for (Furniture furniture : furnitures) {
    if (furniture instanceof Table) {
        doSomethingInKitchen((Table)furniture);
    } else if (furniture instanceof Chair) {
        doSomethingInKitchen((Chair)furniture);
    }
}