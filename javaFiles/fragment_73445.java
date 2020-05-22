private int inputCalls;
private String[] promptMessages = new String[] {"Insert Object Type Here", "Insert x here", "Insert y here"};

@Override
public void show() {
    // ...
    // First input call
    Gdx.input.getTextInput(new MyTextInputListener(), promptMessages[inputCalls = 0], "block", "");
}

public class MyTextInputListener implements TextInputListener {
   @Override
   public void input (String text) {
       // Keep input value
       addInputs[inputCalls++] = text;
       if (inputCalls < promptMessages.length) {
           // show the subsequent input
           Gdx.input.getTextInput(this, promptMessages[inputCalls], "", "");
       }
   }

   @Override
   public void canceled () {
       Gdx.app.log("Input", "Input canceled");
   }
}