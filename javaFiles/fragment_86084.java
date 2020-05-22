public class ProvaTracking extends IMetaioSDKCallback {
    private Contect mCtx;    

    public ProvaTracking(Context context) {
        mCtx = context;
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onTrackingEvent(TrackingValuesVector trackingValuesVector) {
        super.onTrackingEvent(trackingValuesVector);

        for (int i=0; i<trackingValuesVector.size(); i++)
        {
            final TrackingValues v = trackingValuesVector.get(i);
            if (v.isTrackingState())
            {
                TestFragment trendsFragment = new TestFragment();

                if (mCtx instanceof Activity)
                    ((Activity) mCtx).getFragmentManager().beginTransaction().add(android.R.id.content, trendsFragment).commit();

                Log.d("Alessandro", "Works!!");

            }
        }

    }

}