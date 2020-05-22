class MyInputConnection extends BaseInputConnection{

    private MyActivity activity;

    public MyInputConnection(MyActivity activity, View targetView, boolean fullEditor)
    {
       super( targetView, fullEditor );
       mActivity = activity;
    }

    public boolean commitText(CharSequence text, int newCursorPosition){ 
        myActivity.drawText((String) text); 
        return true; 
    }