private OnButtonEventListener mBtnListener; // as you'll pass a Context to your adapter, the Activity which implements the OnButtonEventListener
private void OnClickListener mListener = new OnClickListener() {

      @Override
      public void onClick(View v) {
          Integer rowPosition = (Integer)  v.getTag();// you could pass other data as well
          mBtnListener.onButtonClicked(rowPosition);
      }

}