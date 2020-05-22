boolean lastEnter = false;

....

boolean enter = KeyInput.currentKey(KeyInput.ENTER);
if(enter && !lastEnter) {
    currentMessage++;
}
lastEnter = enter;