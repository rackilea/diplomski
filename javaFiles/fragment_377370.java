private Drawable getShadow(Context context) {
    final int resId = R.drawable.shadow_top;
    @SuppressWarnings("deprecation")
    final Drawable drawable = context.getResources().getDrawable(resId);
    return drawable;
}