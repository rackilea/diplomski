imageField imageField = new imageField ("",Field.FOCUSABLE,"image.png","image.png", 0x102839);
    add(imageField );
    FieldChangeListener listener = new FieldChangeListener() {
    public void fieldChanged(Field field, int context) {
            if (field == imageField ) {
    home home = new home();//your screen
    UiApplication.getUiApplication().pushScreen(home);

                  }
                }
                         };
imageField .setChangeListener(listener);