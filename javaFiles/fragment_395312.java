Collection<CodeToBrands> values = rows.stream()
    .collect(Collectors.toMap(
        RowData::getId,
        rowData -> new CodeToBrands(rowData.getId(), rowData.getName()),
        CodeToBrands::merge))
    .values();