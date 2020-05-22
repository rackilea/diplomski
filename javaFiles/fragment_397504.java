// Build.VERSION_CODES.JELLY_BEAN is API LEVEL 16
if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
    imageView.setBackground(drawable);
} else {
    imageView.setBackgroundDrawable(drawable);
}