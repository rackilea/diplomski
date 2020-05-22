public class SimpleOnItemTouchListener implements OnItemTouchListener {
    // empty, override in your class 
    boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) { return false; }
    // empty, override in your class 
    void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}
    // empty, override in your class 
    void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
}