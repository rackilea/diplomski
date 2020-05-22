private void fadeImageTiles(List<ImageView> ivs) {
    Collections.shuffle(ivs);

    for (int i = 0; i < ivs.size(); i++) {
      //maybe there's problem with iteration?
        gradientFade(ivs.get(i), i);
    }
}

private void gradientFade(ImageView iv, int index){
    AlphaAnimation animation = new AlphaAnimation(1f,0f);
    animation.setDuration(2000);
    animation.setStartOffset(index * 500);
    iv.startAnimation(animation);
    iv.setVisibility(View.INVISIBLE);
}