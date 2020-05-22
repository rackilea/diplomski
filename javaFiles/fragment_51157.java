@NamedNativeQueries({

    @NamedNativeQuery(
            name = "getAllItemType",
            query = "? = CALL GET_ALL_ITEM_TYPE()",
            resultClass = GdItemType.class
            )
})