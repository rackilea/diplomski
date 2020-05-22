LinearLayout layout = (LinearLayout)findViewById(R.id.YOUD VIEW ID);
ViewTreeObserver vto = layout.getViewTreeObserver(); 
vto.addOnGlobalLayoutListener(new OnGlobalLayoutListener() { 
    @Override 
    public void onGlobalLayout() { 
        this.layout.getViewTreeObserver().removeGlobalOnLayoutListener(this); 
        int width  = layout.getMeasuredWidth();
        int height = layout.getMeasuredHeight(); 

    } 
});