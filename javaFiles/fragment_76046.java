List<String> assetItemIds = employees.stream()
        .map(emp -> new AbstractMap.SimpleEntry<>(emp,
                emp.getAssets().stream()
                        .flatMap(asset -> asset.getAssetItem().stream())
                        .filter(assetItem -> assetItem.getOwnerShip().getStartDate() >= emp.getJoiningDate())))
        .flatMap(e -> e.getValue().map(AssetItem::getId))
        .collect(Collectors.toList());