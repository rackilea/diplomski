...

    SystemUiHelper uiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.[Your content view]);
        uiHelper = new SystemUiHelper(this, [Your flags/modes]);
      
        // Then set onTouchListener on youк root view
        // and when someone touch it you will receive an event about it 
        // and will be able to manage it and hide/show app's UI again
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_UP:
                if (uiHelper.isShowing()){
                    uiHelper.hide();
                }else{
                    uiHelper.show();
                }
                break;
        }
      
        return super.onTouchEvent(event);
    }