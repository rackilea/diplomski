public void showActivity(Class<?> to, boolean finish) {
    Intent intent = new Intent(this, to);
    startActivity(intent);
    if (finish) {
        finish();
    }
}