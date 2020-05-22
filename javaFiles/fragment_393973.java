// These are the global variables
public void nativeKeyPressed(NativeKeyEvent e){

    if(e.getKeyCode() == NativeKeyEvent.VC_SPACE){

        System.out.println("Physical - Pressed");

        // This should produce a key release event.
        GlobalScreen.postNativeEvent(new NativeKeyEvent(
            NativeKeyEvent.NATIVE_KEY_RELEASED, 
            e.getWhen(), 
            e.getModifiers(), 
            e.getRawCode(), 
            e.getKeyCode, 
            e.getKeyChar(), 
            e.getKeyLocation()));
    }

}