native void facebookComment(Document d, String s, String id) /*-{
  fbc(d, s, id);
}-*/;

void myFunction() {
  facebookComment(Document.get(), "script", "facebook-jssdk");
}