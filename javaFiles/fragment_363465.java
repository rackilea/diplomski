public void setCardBackground(CardView cardView) {
    ColorDrawable[] color = {new ColorDrawable(Color.BLUE), new ColorDrawable(Color.RED)};
    TransitionDrawable trans = new TransitionDrawable(color);
    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.ICE_CREAM_SANDWICH_MR1) {
        cardView.setBackground(trans);
    } else {
        cardView.setBackgroundDrawable(trans);
    }
    trans.startTransition(5000);
}