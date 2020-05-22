// Utility method
public static boolean fixGestureDetectorScale(GestureDetector detector, float scale) {
    try {
        Field f = GestureDetector.class.getDeclaredField("mTouchSlopSquare");
        f.setAccessible(true);

        int touchSlopSquare = (int) f.get(detector);
        float touchSlop = (float) Math.sqrt(touchSlopSquare);
        //normalize touchSlop
        touchSlop /= scale;
        touchSlopSquare = Math.round(touchSlop * touchSlop);
        f.set(detector, touchSlopSquare);

    } catch (NoSuchFieldException e) {
        e.printStackTrace();
        return false;
    } catch (IllegalAccessException e) {
        e.printStackTrace();
        return false;
    }
    return true;
}