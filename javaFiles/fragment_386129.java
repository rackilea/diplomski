class LayoutUtils {
    private Context context;

    LayoutUtils(context context) {
        this.context = context;
    }

    public int dpToPx(int dp){
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }
}