b.setBackgroundColor(ContextCompat.getColor(b.getContext(), R.color.colorAccent));
b.postDelayed(new Runnable() {
    public void run() {
        b.setBackgroundColor(ContextCompat.getColor(b.getContext(), R.color.initialColor));
    }
}, 800);