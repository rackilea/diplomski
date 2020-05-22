public void donate(String selected) {
   try {
        Bundle buyIntentBundle = mService.getBuyIntent(3, getPackageName(), selected, "inapp", "bGoa+Vlc/yqDXvKRqq+JTFn4uQZbPiQJo4pf9RzJ");
        PendingIntent pendingIntent = buyIntentBundle.getParcelable("BUY_INTENT");

        if(pendingIntent != null) {
            this.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        }else{
            try{
            Bundle ownedItems = mService.getPurchases(3, getPackageName(), "inapp", null);
            int response = ownedItems.getInt("RESPONSE_CODE");
            if (response == 0) {
                ArrayList<String> ownedSkus =
                        ownedItems.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String>  purchaseDataList =
                        ownedItems.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String>  signatureList =
                        ownedItems.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                String continuationToken =
                        ownedItems.getString("INAPP_CONTINUATION_TOKEN");

                for (int i = 0; i < purchaseDataList.size(); ++i) {
                    String purchaseData = purchaseDataList.get(i);
                    String signature = signatureList.get(i);
                    String sku = ownedSkus.get(i);

                    if (sku.equals(selected)){
                        Toast.makeText(getApplication(), "user have this item", Toast.LENGTH_LONG).show();

                        break;
                    }


                }


                // if continuationToken != null, call getPurchases again
                // and pass in the token to retrieve more items
            }}catch (RemoteException e)
            {
                e.printStackTrace();
            }

        }

    } catch (RemoteException e) {
        e.printStackTrace();
    } catch (IntentSender.SendIntentException e) {
        e.printStackTrace();
    }
}}