public class Fragment2 extends Fragment {
    OnButtonClickedListener mCallback;

    // Some kind of init method called by onCreate etc. 
    private void init() {
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Call the listener if present
                if(mCallback != null) {
                    mCallback.onButtonClicked();
                }
            }
        });
    }

    public void setOnButtonClickedListener(Activity activity) {
        mCallback = activity;
    }

    // Container Activity must implement this interface
    public interface OnButtonClickedListener {
        public void onButtonClicked();
    }

    // ...
}