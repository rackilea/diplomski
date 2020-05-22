private class PurchaseFinishListener implements IabHelper.OnIabPurchaseFinishedListener {
   private final String mItemUniqeId;
    public PurchaseFinishListener(String itemUniqeId) {

            mItemUniqeId = itemUniqeId;
        }

       public void onIabPurchaseFinished(IabResult result, Purchase purchase) 
       {
          if (result.isFailure()) {
             Log.d(TAG, "Error purchasing: " + result);
             return;
          }      
    if (!verifyDeveloperPayLoad(mItemUniqeId , purchase)) {
     Log.d(TAG, "Authenticity verification failed");
             return;
    }

    // set your product as purchased in your DB or server

    }
    }