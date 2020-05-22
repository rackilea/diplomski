public class StartUp extends UiApplication
{

    public static void main(String[] args) {
        StartUp start=new StartUp();
        start.enterEventDispatcher();
    }
    public StartUp() 
    {
        UiApplication.getUiApplication().pushScreen(new RefreshSCreen());

    }
}

    class RefreshSCreen extends MainScreen implements FocusChangeListener
    {
        HorizontalFieldManager imgScrollView;
        VerticalFieldManager vmanager;
        LabelField lable;
        BitmapField bmf[];
        private Vector vImages=null;
        public RefreshSCreen() {
            vImages=new Vector();
            for(int i=0;i<8;i++){
                Bitmap image=Bitmap.getBitmapResource("sample_"+i+".jpg");
                vImages.addElement(image);
            }
             imgScrollView = new HorizontalFieldManager(
                        USE_ALL_WIDTH | HORIZONTAL_SCROLL);

                // Get list bitmap 
             bmf=new BitmapField[vImages.size()];
                for (int i = 0; i < vImages.size(); i++) {

                    bmf[i] = new BitmapField((Bitmap) vImages.elementAt(i), BitmapField.ACTION_INVOKE | BitmapField.FOCUSABLE) {
                        protected void drawFocus(Graphics graphics, boolean on) {
                            graphics.setColor(Color.BLUE);
                            graphics.drawRect(0, 0, getWidth() - 4, getHeight() - 4);
                            graphics.drawRect(1, 1, getWidth() - 6, getHeight() - 6);

                        }
                    };
                    bmf[i].setFocusListener(this);
                    bmf[i].setPadding(2, 2, 2, 2);
                    bmf[i].setMargin(2, 2, 2, 2);
                    imgScrollView.add(bmf[i]);
                }
                add(imgScrollView);
                vmanager=new VerticalFieldManager();
                add(vmanager);


        }

        public void focusChanged(Field field, int eventType) {

            for(int i=0;i<vImages.size();i++){
                if(field==bmf[i]){
                    if(bmf[i].isFocus()){
                        synchronized (UiApplication.getEventLock()) {
                            vmanager.deleteAll();
                            vmanager.invalidate();
                            lable=new LabelField("Hi I am reference of Image number "+i);
                            vmanager.add(lable);
                        }
                    }
                }
            }
        }
    }