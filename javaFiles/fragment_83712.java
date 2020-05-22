private class BillingPurchaseObserver extends PurchaseObserver {
        public BillingPurchaseObserver(Handler handler) {
            super(Pro.this, handler);
        }

        @Override
        public void onBillingSupported(boolean supported) {

            if (supported) {
                //Enable buy functions. Not required, but you can do stuff here. The market first checks if billing is supported. Maybe your country is not supported, for example. 
            } else {
                Toast.makeText(getApplicationContext(), R.string.billing_not_supported, Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void onPurchaseStateChange(PurchaseState purchaseState, String itemId,
                int quantity, long purchaseTime, String developerPayload) {

//This is the method that is called when the buy is completed or refunded I believe. 
// Here you can do something with the developerPayload. Its basically a Tag you can use to follow your transactions. i dont use it. 

        BillingItem item = BillingItem.getBySku(getApplicationContext(), itemId);

        if (purchaseState == PurchaseState.PURCHASED) {
            if (item != null){
//This is my own implementation that sets the item purchased in my database. BillingHelper is a class with methods I use to check if the user bought an option and update the UI. You should also check for refunded. You can see the Consts class to find what you need to check for. 

                    boolean resu = item.makePurchased(getApplicationContext());
                    if (resu){                      
                        Toast.makeText(getApplicationContext(), R.string.billing_item_purchased, Toast.LENGTH_LONG).show();
                    }
                }
            }
        }

        private void trackPurchase(BillingItem item, long purchaseTime) {           
            //My code to track the purchase in GA
        }

        @Override
        public void onRequestPurchaseResponse(RequestPurchase request,
                ResponseCode responseCode) {

               //This is the callback that happens when you sent the request. It doesnt mean you bought something. Just that the Market received it. 

            if (responseCode == ResponseCode.RESULT_OK) {               

                Toast.makeText(getApplicationContext(), R.string.billing_item_request_sent, Toast.LENGTH_SHORT).show();

            } else if (responseCode == ResponseCode.RESULT_USER_CANCELED) {
                //The user canceled the item. 
            } else {
            //If it got here, the Market had an unexpected problem. 
            }
        }

        @Override
        public void onRestoreTransactionsResponse(RestoreTransactions request,
                ResponseCode responseCode) {
            if (responseCode == ResponseCode.RESULT_OK) {
//Restore transactions should only be run once in the lifecycle of your application unless you reinstalled the app or wipe the data. 

                SharedPreferences.Editor edit = PreferencesHelper.getInstance().getDefaultSettings(getApplicationContext()).edit();
                edit.putBoolean(Consts.DB_INITIALIZED, true);
                edit.commit();

            } else {
    //Something went wrong
            }
        }
    }