public class AssetCategories {
    private final static Comparator<AssetCategory> COMPARATOR = new IntersectComparator();

    private Map<String, List<AssetCategory>> assets = new HashMap<>();

    public void add(AssetCategory assetCategory) {
        List<AssetCategory> categories = assets.computeIfAbsent(assetCategory.getAsset(), k -> new ArrayList<>());
        int insert = Collections.binarySearch(categories, assetCategory, COMPARATOR);
        if (insert >= 0) {
            throw new IllegalArgumentException("Asset category dates intersect with existing asset category");
        }
        categories.add(-insert - 1, assetCategory);
    }

    public AssetCategory fetchAssetCategory(String asset, LocalDate date) {
        List<AssetCategory> categories = assets.get(asset);
        if (categories == null) {
            return null;
        }
        int index = Collections.binarySearch(categories,
                new AssetCategory(asset, "SEARCH", date, date),
                COMPARATOR);

        return index < 0 ? null : categories.get(index);
    }

    public boolean validateAssetCategory(String asset, String category, LocalDate date) {
        AssetCategory assetCategory = fetchAssetCategory(asset, date);
        return assetCategory != null && assetCategory.getCategory().equalsIgnoreCase(category);
    }
}