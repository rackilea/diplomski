chatInputET.addTextChangedListener( new TextWatcher(){
  @Override
  public void onTextChanged( CharSequence txt, int start, int before, int count ) {
    if( -1 != txt.toString().indexOf("\n") ){
      doSendMsg();
    }
  }
} );