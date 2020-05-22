editText.setOnTouchListener(new View.OnTouchListener() 
{
      public boolean onTouch(View p_v, MotionEvent p_event)
       {
          // this will disallow the touch request for parent scroll on touch of child view
           p_v.getParent().requestDisallowInterceptTouchEvent(true);
           return false;
       }
});