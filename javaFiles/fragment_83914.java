public boolean keyChar(char key, int status, int time) {
  if ( key == Characters.ESCAPE) {
    if(yourBrowserField.getHistory().canGoBack()){
      yourBrowserField.getHistory().goBack();
    }else{
      UiApplication.getUiApplication().popScreen(this);
      return true;
    }
   }
}