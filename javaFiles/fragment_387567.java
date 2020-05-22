final String newText = i.toString();
 Display.getDefault().asyncExec(new Runnable() {
    @Override
    public void run() {
      text.setText(newText);
    }
 });