for (Map<String, Object> row : rows) {
    Long regionId = calculateIfKeyPresent(row, "country",
            (value) -> Region.getRegionByName(value.toString().toLowerCase()).getDbVal(), -1L);
    Long principalId = calculateIfKeyPresent(row, "main_cat", (value) -> Long.parseLong(value.toString()), -1L);
    Long categoryId = -1L;
    String mainCategoryName = calculateIfKeyPresent(row, "main_category", Object::toString, "");
    String subCategoryName = calculateIfKeyPresent(row, "sub_category", Object::toString, "");
    String level3CategoryName = calculateIfKeyPresent(row, "level3_category", Object::toString, "");
    Long lft = calculateIfKeyPresent(row, "sub_cat", (value) -> Long.parseLong(value.toString()), -1L);
    Long rft = calculateIfKeyPresent(row, "level3_cat", (value) -> Long.parseLong(value.toString()), -1L);
    Long parentId = -1L;

    List<CategoryDto> categoryDtoList = getList(regionId, categoryId, lft, rft, mainCategoryName, subCategoryName, level3CategoryName);

}