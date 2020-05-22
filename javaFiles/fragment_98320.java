text1.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(text1!=null && !text1.trim().equals("")){
         switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                text1.setBackgroundColor(Color.RED);
            InputConnection ic = getCurrentInputConnection();
            ic.commitText(textOne, 1);
              break;
            case MotionEvent.ACTION_UP:
                 text1.setBackgroundColor(Color.YELLOW);
              break;
        }     
    }

        return true;
    }
}