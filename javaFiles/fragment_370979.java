pager.setOnTouchListener(new View.OnTouchListener() 
{
       public boolean onTouch(View p_v, MotionEvent p_event) 
        {
               editText.getParent().requestDisallowInterceptTouchEvent(false);
           //  We will have to follow above for all scrollable contents
           return false;
        }
});