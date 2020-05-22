public void nativeMousePressed(NativeMouseEvent nativeMouseEvent)
{
    if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON1)
    {
        max = Native.get().getFrame().getCps().getValue() + Native.get().getFrame().getDev().getValue();
        min = Native.get().getFrame().getCps().getValue() - Native.get().getFrame().getDev().getValue();
        mouseDown = true;
        initThread();
    }
}