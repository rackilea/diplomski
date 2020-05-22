private class BuyButton implements DialogInterface.OnClickListener {

       private BillingItem item = null;
       private String developerPayload;

       public BuyButton(BillingItem item, String developerPayload) {
        this.item = item;
        this.developerPayload = developerPayload;
        }

            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (GeneralHelper.isOnline(getApplicationContext())){
                    //I track the buy here with GA SDK. 

        mBillingService.requestPurchase(this.item.getSku(), this.developerPayload);             
                } else {                
                    Toast.makeText(getApplicationContext(), R.string.msg_not_online, Toast.LENGTH_SHORT).show();
                }

            }

        }