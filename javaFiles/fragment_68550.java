@Override
public void onClick(View view) {
    if (view.getId() == R.id.sign_out_button) {
        if (mPlusClient.isConnected()) {
            mPlusClient.clearDefaultAccount();
            mPlusClient.disconnect();
            mPlusClient.connect();
        }
    }
}