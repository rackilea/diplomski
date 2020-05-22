private void dimActivity(Dialog dialog, float dimAmount) {
    WindowManager.LayoutParams lp = dialog.getWindow().getAttributes();
    lp.dimAmount = dimAmount;
    dialog.getWindow().setAttributes(lp);
    dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
}