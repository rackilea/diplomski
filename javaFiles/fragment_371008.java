public static abstract class BaseKeyListener extends DigitsKeyListener {
  private BaseKeyListener() {
    super(); 
  }

  private BaseKeyListener(Locale locale) {
    super(locale);
  }

  public static BaseKeyListener newInstance(Locale locale) {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      return new BaseKeyListener(locale);
    } else {
      return new BaseKeyListener();
    }
  }
}