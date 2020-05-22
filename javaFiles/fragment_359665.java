public class MySingleLineInList extends LinearLayout {

public MySingleLineInList(Context context) {
    super(context);

      setOrientation(LinearLayout.HORIZONTAL);

      EditText courseET = new EditText(context);
      EditText creditsET = new EditText(context);
      CheckBox complteCB = new CheckBox(context);

      addView(courseET);
      addView(creditsET);
      addView(complteCB);
}
}