highscoreView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (v.getContext() instanceof Activity) {
            ((Activity)v.getContext()).finish();
        }
    }
});