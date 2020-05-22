@Override
public void onPurchasesUpdated(
        BillingResult billingResult,
        List<Purchase> purchases) {

    if (responseCode == BillingClient.BillingResponse.OK
                && purchases != null) {

            for (Purchase purchase : purchases) {

                handlePurchase(purchase);
                consumePurchase(purchase);

            }
        }
}