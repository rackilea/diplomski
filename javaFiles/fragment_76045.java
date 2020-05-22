List<String> assetItemIds = new ArrayList<>();
for (Employee employee : employees) {
    assetItemIds.addAll(employee.getAssets().stream()
            .flatMap(asset -> asset.getAssetItem().stream())
            .filter(assetItem -> assetItem.getOwnerShip().getStartDate() >= employee.getJoiningDate())
            .map(AssetItem::getId)
            .collect(Collectors.toList()));
}