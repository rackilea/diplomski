imageView.animate().withEndAction(new Runnable() {
    @Override
    public void run() {
        imageView.setImageResource(R.drawable.img_guitar);
    }
})