public class Pro extends TrackedActivity implements OnItemClickListener {

            private BillingService mBillingService;
            private BillingPurchaseObserver mBillingPurchaseObserver;
            private Handler mHandler;

            @Override
            protected void onCreate(Bundle savedInstanceState) {    
                super.onCreate(savedInstanceState);     
                setContentView(R.layout.pro);


                //Do my stuff

                mBillingService = new BillingService();
                mBillingService.setContext(getApplicationContext());

                mHandler = new Handler();
                mBillingPurchaseObserver = new BillingPurchaseObserver(mHandler);

            }

        }



    @Override
    protected void onStart() {
       //Register the observer to the service
        super.onStart();
        ResponseHandler.register(mBillingPurchaseObserver);   
    }


    @Override
    protected void onStop() {
        //Unregister the observer since you dont need anymore
        super.onStop();
        ResponseHandler.unregister(mBillingPurchaseObserver);
    }

    @Override
    protected void onDestroy() {
       //Unbind the service
        super.onDestroy();
        mBillingService.unbind();
    }