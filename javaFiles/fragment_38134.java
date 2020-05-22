@Override
public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
    if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON1)
    {
        pressed = true;
        System.out.println(pressed);
        repeatMouse();
    }
}