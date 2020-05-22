List<String> skuList = new ArrayList<> ();
skuList.add("item1");
skuList.add("item2");
SkuDetailsParams.Builder params = SkuDetailsParams.newBuilder();
params.setSkusList(skuList).setType(BillingClient.SkuType.INAPP);
billingClient.querySkuDetailsAsync(params.build(),
                    new SkuDetailsResponseListener() {
                        @Override
                        public void onSkuDetailsResponse(BillingResult billingResult,
                                                         List<com.android.billingclient.api.SkuDetails> skuDetailsList) {
                            if (billingResult.getResponseCode() == 
                                BillingClient.BillingResponseCode.OK && skuDetailsList != null) {
                                for (com.android.billingclient.api.SkuDetails skuDetails : skuDetailsList) {
                                    mSkuDetailsMap.put(skuDetails.getSku(), skuDetails);//will use this for purchase calls
                                }
                            }
                        }
                    });