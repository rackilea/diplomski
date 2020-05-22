WindowManager windowManager  = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
    layoutParams.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
} else {
    layoutParams.type = WindowManager.LayoutParams.TYPE_PHONE;
}
layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
layoutParams.x = 0;
layoutParams.y = 0;
layoutParams.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
        | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
View window = LayoutInflater.from(this).inflate(R.layout.layout_window, null, false);
window.findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Toast.makeText(FirstActivity.this, "Click Lock", Toast.LENGTH_SHORT).show();
    }
});
windowManager.addView(window, layoutParams);