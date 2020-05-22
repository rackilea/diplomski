for (int c = 0; c<ff.size(); c++) {
    if(mStreet.getText().toString().equals(ff.get(c).name)) {
        mActivity.finishActivityWithResult(mCurrentId);
    }
    else {
        Toast.makeText(mActivity, "Delivery Address not match", Toast.LENGTH_SHORT).show();
        break; // this will terminate your loop
    }
}