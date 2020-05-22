@Override 
public void onAttach(Context context) {
    super.onAttach(context);
    try {
        responseListener = (ResponseListener) getParentFragment();
    } catch(Exception e) {
       //handle exception
    }
}