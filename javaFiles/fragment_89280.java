//SET A DRAWABLE TO IMAGEVIEW
Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
getSupportActionBar().setCustomView(R.layout.actionbar_main);

TextDrawable drawable = TextDrawable.builder()
        .buildRound("A", getResources().getColor(R.color.colorAccent));
ImageView imageView = (ImageView) findViewById(R.id.image_view);
imageView.setImageDrawable(drawable);