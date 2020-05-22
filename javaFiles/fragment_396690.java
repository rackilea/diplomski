...
Bundle bandleSKU = new Bundle();
ArrayList<String> productIds = new ArrayList<>(1);
productIds.add("<someProductID>");
querySkus.putString(GET_SKU_DETAILS_ITEM_LIST, productIds); 
Bundle skuDetails = mService.getSkuDetails(API_VERSION, PACKAGE_NAME, type, bandleSKU);

if (null != skuDetails) {
    int response = skuDetails.getInt(RESPONSE_CODE);
    if (response == BILLING_RESPONSE_RESULT_OK) {
        ArrayList<String> responseList = skuDetails.getStringArrayList(RESPONSE_GET_SKU_DETAILS_LIST);
        String productDetailsJson = responseList.get(0);
    }
}
...