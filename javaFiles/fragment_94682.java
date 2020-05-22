public class MySlideListener extends View.OnTouchListener{

    private View v;
    private GestureDetector gestureDetector;

    public MySlideListener (View v){
        this.v = v;
        gestureDetector = new GestureDetector(v.getContext(), myGestureListener);
    }

   public boolean onTouch (View v, MotionEvent event){
         return gestureDetector.onTouchEvent(event);
   }

    private SimpleOnGestureListener myGestureListener = new SimpleOnGestureListener(){
        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){

           // now here we make the view scroll
           MarginLayoutParams lp = (MarginLayoutParams) view.getLayoutParams();
           lp.leftMargin = distanceX;
           lp.rightMargin = -distanceX;

          // You might need to call view.requestLayout();
          //  but first give it a try without it

          // This part of the method for processing the horizontal
          // offset can (and should) be further developed to add some
          // 'snap-in' or transparency functionality to make the whole
          // concept work better.
          // But this code should give you a proof of concept on how to deal with stuff.

          // The important part is that now you have a call back that have access
          // to the view during onScroll.

          // Also might be necessary to enable/disable the bottomContent view
          // in order for it to be not clickable whilst not visible.

           return true;
        }
    }
}