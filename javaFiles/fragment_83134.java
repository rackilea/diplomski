List<DBObject> pipeline = Arrays.<DBObject>asList(
    new BasicDBObject("$match",new BasicDBObject("categoryID", 4)),
    new BasicDBObject("$group",
        new BasicDBObject("_id",
            new BasicDBObject("productID","$productID")
                .append("articleID", "$articleID")
                .append("colour", "$colour")
        )
        .append("size",new BasicDBObject("$addToSet",
            new BasicDBObject("sku","$skuID")
                .append("size","$size")
        )
    )
);