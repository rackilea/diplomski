public Where<Item, Integer> getWhereSearchOnNameLight(String searchName) {
    try {
        return itemsDao.queryBuilder().where()
                                      .like(Item.COLUMN_NAME, "%" + searchName + "%")
                                      .selectColumns(Item.COLUMN_ID,
                                                     Item.COLUMN_NAME,
                                                     Item.COLUMN_CATEGORY_ID);
    } catch (SQLException e) { e.printStackTrace(); }
    return null;
}