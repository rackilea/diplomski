...

if (!StringUtils.isEmpty(tagsSearch.getValue())) {
     //Util.parseCommaSeparated returns Set<String>
    where = builder.and(where, product.join("productTags").in(Util.parseCommaSeparated(tagsSearch.getValue())));
}

...