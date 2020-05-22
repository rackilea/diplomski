public class MyOwnOnItemTouchListener extends SimpleOnItemTouchListener { //extend Simple instead of implementing interface

    @Override
    boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        boolean result = doSomething(e);
        return result;
    }

    @Override
    void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        doSomethingElse(rv, e);
        doSomethingMore(rv);
    }

    @Override
    void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        if (disallowIntercept) {
            doADifferentThing();
        }
    }
}