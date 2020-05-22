Collection<CodeToBrands> values = rows.stream()
    .collect(Collectors.toMap(
        RowData::getId,
        rowData -> {
            CodeToBrands codeToBrands = new CodeToBrands();
            codeToBrands.setCode(rowData.getId());
            codeToBrands.addBrand(row.getName());
            return codeToBrands;
        },
        (left, right) -> {
            left.addBrands(right.getBrands());
            return left;
        }))
    .values();