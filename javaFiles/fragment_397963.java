Platform.runLater( () -> {
        if(nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_ALT_L){
            alt = true;
        }
        if(nativeKeyEvent.getKeyCode() == NativeKeyEvent.VC_T){
            t = true;
        }

        check();
    } );