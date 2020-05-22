public class CustomResourceProxy extends DefaultResourceProxyImpl {

      private final Context mContext;
      public CustomResourceProxy(Context pContext) {
           super(pContext);
        mContext = pContext;
      }

      @Override
    public Bitmap getBitmap(final bitmap pResId) {
        switch (pResId){
                case person:
                     //your image goes here!!!
                     return BitmapFactory.decodeResource(mContext.getResources(),org.osmdroid.example.R.drawable.sfgpuci);

           }
           return super.getBitmap(pResId);
    }

    @Override
    public Drawable getDrawable(final bitmap pResId) {
        switch (pResId){
                case person:
                     //your image goes here!!!
                     return mContext.getResources().getDrawable(org.osmdroid.example.R.drawable.sfgpuci);
           }
           return super.getDrawable(pResId);
    }

 }