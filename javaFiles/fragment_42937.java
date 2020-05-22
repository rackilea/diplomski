public void ShowPopup() {
    dialog = new Dialog(this);    // Initialize dialog before use
    dialog.setContentView(R.layout.mainactiv);
    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    dialog.show();
}