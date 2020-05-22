ImageView counter = findViewById(R.id.imageView5);
counter.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        counter.setTranslationY(1000f);
        counter.setImageResource(R.drawable.yellow);
        counter.animate().translationYBy(1000f).setDuration(300);
    }
 });