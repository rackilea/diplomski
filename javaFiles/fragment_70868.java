public void nativeKeyPressed(NativeKeyEvent e) {
    String keyText = NativeKeyEvent.getKeyText(e.getKeyCode());
    switch(keyText){
    case "Escape": //close code (esc key)
        System.out.println("Pressed esc");
        System.exit(0);
        break;
    case "P": //pause code (p key)
        System.out.println("Pressed p");
        run = !run;
        check();
        break;
    case "C": //copy code (c key)
        System.out.println("Pressed c");
        StringSelection ss = new StringSelection(MouseInfo.getPointerInfo().getLocation().toString().replaceAll("java.awt.Point", "").replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("=", "").replaceAll("x", "").replaceAll("y", "").replaceAll(",", ", ")); //get mouse coordinates and set them as a StringSelection
        Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard(); //get the clipboard
        cb.setContents(ss, ss); //set what is copied to the current mouse coordinates
        break;
    }
}

public void nativeKeyReleased(NativeKeyEvent e) {

}