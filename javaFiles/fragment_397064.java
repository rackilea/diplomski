public void hide(View view) {
    String text = b1.getText().toString();
    if (text.equals("Hide")) {
        t1.setVisibility(View.INVISIBLE);
        b1.setText("Unhide");
    } else if (text.equals("Unhide")) {
        t1.setVisibility(View.VISIBLE);
        b1.setText("Hide");
    }
}