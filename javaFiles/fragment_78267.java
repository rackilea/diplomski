public interface OnItemTouchListener {
    boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e);
    void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e);
    void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept);
    // New method
    void onMultiTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e);
}
public class SimpleOnItemTouchListener implements OnItemTouchListener {
    // empty, override in your class 
    boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) { return false; }
    // empty, override in your class 
    void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}
    // empty, override in your class 
    void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {}
    // New method
    // empty, override in your class 
    void onMultiTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {}
}