public class MyCustomView extends LinearLayout {

  // Note: I am not inflating the layout here

  public void foo() {
      // Do some foo
  }

  public void setTitle(String text) {
      findViewById(R.id.textView).setText(text);
  }
  ....

}