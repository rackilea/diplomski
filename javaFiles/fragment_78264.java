public interface OnItemTouchListener {
    boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e);
    void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e);
    void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept);
    // New method
    void onMultiTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e);
}