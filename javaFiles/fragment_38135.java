@Override
public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
    if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON1)
    {
        if(skipRelease) {
            skipRelease = false;
            return;
        }
        pressed = false;
        System.out.println(pressed);
    }
}