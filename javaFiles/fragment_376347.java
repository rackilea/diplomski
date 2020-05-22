sellerDataList.stream().forEach(sellerNames -> {
        Stream<String> stream = StreamSupport.stream(sellerNames.spliterator(), true); // true means use parallel stream
        stream.forEach(sellerName -> {
            getSellerAddress(sellerName);
        });
    });