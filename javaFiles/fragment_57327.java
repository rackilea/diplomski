new Thread() {
    public void run() {
        Point mouse;
        int mousex;
        int mousey;
        while (true) {
            mouse = MouseInfo.getPointerInfo().getLocation();
            mousex = mouse.x - theWindow.getLocationOnScreen().x - 3; // You'll need to get the 
                // x coordinate, subtract the window's x coordinate, and subtract 3 because of 
                // the blue border around a standard pc window.
            mousey = mouse.y - theWindow.getLocationOnScreen().y - 29; // 29 is top bar height
            SomeOtherClass.processMove(mousex, mousey);
        }
    }
}.start();