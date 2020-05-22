public static void main(String[] args) {
        frame.setSize(500,300);
        frame.setLocation(300,200);
        frame.setVisible(true);
        frame.setBackground(Color.black);

        try {
            final Robot robot = new Robot();
            handleMouse(robot);
        } catch (final AWTException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static void handleMouse(final Robot robot) {
        int mouseX = 1;
        int mouseY = 1;
        while (mouseX !=0 || mouseY !=0) {
            final Point mouseLocation = MouseInfo.getPointerInfo().getLocation();
            mouseX = mouseLocation.x;
            mouseY = mouseLocation.y;
            final Color currentColor = robot.getPixelColor(mouseX, mouseY);
            System.out.println(String.format("x: %d, y: %d, c: %s", mouseX, mouseY, currentColor));
        }
    }