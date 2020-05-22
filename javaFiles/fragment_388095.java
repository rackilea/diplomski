Map<Integer, String> itemNamesCache =
dslContext.selectDistinct(ITEMNAMES.ITEMID, ITEMNAMES.NAME)
          .from(ITEMNAMES)
          .fetchMap(ITEMNAMES.ITEMID, ITEMNAMES.NAME);

dslContext
    .select(
        ITEMDATA.ITEMID,
        ITEMDATA.COST,
        // create an empty column here
        inline(null, String.class).as(ITEMNAMES.NAME))
    .from(ITEMDATA)
    .where(conditions)
    // fill the empty column with cached values
    .fetch(r -> r.value3(itemNamesCache.get(r.value1())));