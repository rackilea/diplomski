public void keyPressed ( KeyEvent event ) {
        switch ( event.getKeyCode ()) {
            case KeyEvent.VK_TAB :
                insertTabChar ( event.isShiftDown ());
                event.consume ();
                break;
            case KeyEvent.VK_ENTER :
                snapshot ();
                insertNewLine ();
                event.consume ();
                break;
        }
    }