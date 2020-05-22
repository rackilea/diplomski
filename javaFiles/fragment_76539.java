public void mouseEntered(MouseEvent e) {
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                if (menuItem.isShowing())
                {
                    Point mouseLoc = MouseInfo.getPointerInfo().getLocation();
                    Point menuLoc = menuItem.getLocationOnScreen();
                    if (mouseLoc.x >= menuLoc.x && mouseLoc.x <= menuLoc.x + menuItem.getWidth() &&
                            mouseLoc.y >= menuLoc.y && mouseLoc.y <= menuLoc.y + menuItem.getHeight())
                    {
                        originalMouseEnteredStuff();
                    }
                }
            }
        }, 100);
    }