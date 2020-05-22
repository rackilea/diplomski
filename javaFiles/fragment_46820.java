Ajax.get("http://localhost/folder?sessionId=foo&path=bar")
    .done(new Function(){
      public void f() {
        String text = arguments(0);
      }
    });