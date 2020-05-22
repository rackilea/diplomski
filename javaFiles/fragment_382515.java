@Override
public void onAttach(Context context) {
    // here, your context is also your activity
    super.onAttach(context);
    if (context instanceof YourListener) {
        this.fragmentListener = (YourListener) context;
    }
}