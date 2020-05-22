public void onClickSlideDown(View view) {

    Animation slideback;
    ImageView iconimage, whitebox;
    TextView titletext, title_2text, descriptiontext;
    titletext = (TextView)findViewById(R.id.title);
    title_2text = (TextView)findViewById(R.id.title_2);
    descriptiontext = (TextView)findViewById(R.id.description);
    iconimage = (ImageView)findViewById(R.id.icon);
    whitebox = (ImageView)findViewById(R.id.whitebox);
    slideback = AnimationUtils.loadAnimation(this, R.anim.whiteboxanimback);
    slideback.setAnimationListener(this);
    whitebox.startAnimation(slideback);
    iconimage.startAnimation(slideback);
    titletext.startAnimation(slideback);
    title_2text.startAnimation(slideback);
    descriptiontext.startAnimation(slideback);

    if (viewPager.getCurrentItem() < viewPager.getAdapter().getCount()) {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true);
    } else {
        Intent i1 = new Intent(this, glass_3.class);
        startActivity(i1);
    }

}