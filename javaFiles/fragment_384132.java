public static ScreenSlidePageFragment newInstance(String text, @DrawableRes int drawable) {
  ScreenSlidePageFragment f = new ScreenSlidePageFragment();
  Bundle b = new Bundle();
  b.putString("msg", text);
  b.putInt("letter", drawable); // this is the image in your drawable folder that you can access with R.drawable.letter_a (if the file is called letter_a.png

  f.setArguments(b);

  return f;
}