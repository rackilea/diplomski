@Override
public void onPurchasesUpdated(List<Purchase> purchaseList) {

        for (Purchase purchase : purchaseList) {
            if (purchase.getSku().equals(SKU_MONTHLY)) {
                Log.d(TAG, "Subscription is valid! - server");
                mMonthlySubscribed = true;
            }
        }
        //// save state and notify the current state to the fragment
        saveSubscriptionStateSharedPreference();
        sendMessage();
}