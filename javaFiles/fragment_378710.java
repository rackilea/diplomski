IabHelper.QueryInventoryFinishedListener mGotInventoryListener = new IabHelper.QueryInventoryFinishedListener() {
        public void onQueryInventoryFinished(IabResult result, Inventory inventory) {
           Log.d(TAG, "Query inventory finished.");

            // Have we been disposed of in the meantime? If so, quit.
            if (mHelper == null) return;

            // Is it a failure?
            if (result.isFailure()) {
                Log.d(TAG, "Failed to query inventory: " + result);
                return;
            }

            Purchase premiumMonthly = inventory.getPurchase(SKU_SUSCRIPTION);
            if (premiumMonthly != null && premiumMonthly.isAutoRenewing()) {
                    String token = premiumMonthly.getToken();
                    String orderid = premiumMonthly.getOrderId();

                    Log.d(TAG, token);
                    Log.d(TAG, orderid);
                } 
            }
   ....

    mHelper.queryInventoryAsync(mGotInventoryListener);