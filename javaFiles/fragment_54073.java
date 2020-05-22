public static final int BUTTONS_WIDTH_COUNT = 9;
    public static final int BUTTONS_HEIGHT_COUNT = 9;
    public static final Button[][] BUTTONS = new Button[BUTTONS_WIDTH_COUNT][BUTTONS_HEIGHT_COUNT]
    ...

    // I'll assume that the buttons are taking up the entire frame so no offsets are taken into account
    frame.addMouseListener(
        new MouseAdaptor() {
            mouseClicked(MouseEvent e) {
            // The X Y coordinates are relative to the component so
            int frameWidth = frame.getBounds().getWidth();
            int frameHeight = frame.getBounds().getHeight();

            Button buttonClicked = buttons[e.getX()/(frameWidth/BUTTONS_WIDTH_COUNT)][e.getY()/(frameHeight/BUTTONS_HEIGHT_COUNT)];
        }
    }