private void doSomething() {
  // TODO: Something!
}

....

myCombo.addModifyListener(new ModifyListener(){

public void modifyText(ModifyEvent arg0) {
  doSomething();
}});

doSomething();