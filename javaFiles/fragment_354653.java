for (DataItem dataItem : dataItems) {
    System.out.println("the type of this dataItem is " + dataItem.getMajorType());
    switch(dataItem.getMajorType()) {
        UNSIGNED_INTEGER:
            UnsignedInteger unsignedInteger = (UnsignedInteger) dataItem;
            System.out.println("the value of this dataItem is " + unsigendInteger.getValue());
        /* ... add missing ones */
        default:
            System.out.println("unknown type: " + dataItem.getMajorType());
    }
}