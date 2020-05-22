public void init(Map map) {
    this.productIds = new ArrayList();
    try {
        if (map.containsKey("products")) {

            // ***** We now specify the type of object that the Set contains.
            Set<Map.Entry<String, Object>> entrySet = ((HashMap) hm.get("products")).entrySet();

            for (Entry<String, Object> entry : entrySet) {
                InAppProduct productId = new InAppProduct();
                productId.productId = ((String) entry.getKey()).toLowerCase();
                HashMap<String, Object> extraValues = (HashMap) entry.getValue();
                if (extraValues.containsKey(ShareConstants.MEDIA_TYPE)) {
                    productId.productType = (String) extraValues.get(ShareConstants.MEDIA_TYPE);
                }
                if (extraValues.containsKey("days")) {
                    productId.days = ((Integer) extraValues.get("days")).intValue();
                }
                this.productIds.add(productId);
            }
            return;
        }
        this.productIds = new ArrayList(ConfigurationFetcher.this.mDefaultsDelegate.getDefaultsInAppPackages());
    } catch (Exception e) {
        e.printStackTrace();
    }
}