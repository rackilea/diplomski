if (CollectionUtils.isNotEmpty(rows)) {
        for (Map<String, Object> row : rows) {
            Long regionId = row.containsKey("country") ?
                    Region.getRegionByName(row.get("country").toString().toLowerCase()).getDbVal() : -1L;
            Long principalId = row.containsKey("main_cat") ? Long.parseLong(row.get("main_cat").toString()) : -1L;
            Long categoryId = -1L;
            String mainCategoryName = row.containsKey("main_category") ? row.get("main_category").toString() : "";
            String subCategoryName = row.containsKey("sub_category") ? row.get("sub_category").toString() : "";
            String level3CategoryName = row.containsKey("level3_category") ? row.get("level3_category").toString() : "";;
            Long lft = row.containsKey("sub_cat") ? Long.parseLong(row.get("sub_cat").toString()) : -1L;
            Long rft = row.containsKey("level3_cat") ? Long.parseLong(row.get("level3_cat").toString()) : -1L;
            Long parentId = -1L;

            List<CategoryDto> categoryDtoList = getList(regionId, categoryId, lft, rft, mainCategoryName, subCategoryName, level3CategoryName);

        }
    }