public class BaseTouchManager extends Manager {

    private FieldChangeListener _callBack;

    public BaseTouchManager(FieldChangeListener pCallBack) {
        super(0);
        _callBack = pCallBack;
        setChangeListener(new FieldChangeListener() {

            public void fieldChanged(Field field, int context) {
                _callBack.fieldChanged(field, context);
            }
        });

        add(new NullField(Field.FOCUSABLE));
    }

    protected void sublayout(int width, int height) {
        setExtent(Display.getHeight()/2, 100);
    }

    protected boolean navigationClick(int status, int time) {
            fieldChangeNotify(1);
            return true;
    }

    public void paint(Graphics graphics) {
        if(_callBack!=null){
            if(isFocus())
                graphics.setColor(Color.LIGHTBLUE);
            else
                graphics.setColor(Color.WHITE);
            graphics.fillRect(this.getWidth() - 10, 
                    this.getHeight() - 10, 
                    10, 10);

        }
        super.paint(graphics);  
    }
}