List<DBObject> pipeline = Arrays.<DBObject>asList(
    new BasicDBObject("$match",new BasicDBObject("categoryID", 4)),
    new BasicDBObject("$group",
        new BasicDBObject("_id",
            new BasicDBObject("productID","$productID")
                .append("articleID", "$articleID")
                .append("colour", "$colour")
                .append("size",
                    new BasicDBObject("sku","$skuID")
                        .append("size","$size")
                )
        )
    ),
    new BasicDBObject("$group",
        new BasicDBObject("_id",
            new BasicDBObject("productID","$_id.productID")
                .append("articleID", "$_id.articleID")
                .append("colour", "$_id.colour")
        )
        .append("size",new BasicDBObject("$push","$_id.size")
    ),
    new BasicDBObject("$project",
        new BasicDBObject("_id",0)
        .append("productID","$_id.productID")
        .append("colour","$_id.colour")
        .append("size",1)
    )
);