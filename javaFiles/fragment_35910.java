@RequestMapping(value = "/delete-asset", method = RequestMethod.POST)
public @ResponseBody String deleteAsset(@ModelAttribute List<AssetCategory> assetCategories) {
    JsonObject result = new JsonObject();
    if (assetCategories != null && !assetCategories.isEmpty()) {
        String[] arr = new String[assetCategories.size()];
        for (int i =0; i < assetCategories.size(); i++) {
            arr[i] = assetCategories.get(i).getAssetID();
        }
        assetService.deleteAssets(arr);
        result.addProperty("result", "Success");
        result.addProperty("status", 1);
        result.addProperty("message", "Asset Deleted!");
    }
    return result.toString();
}