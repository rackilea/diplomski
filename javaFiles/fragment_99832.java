//The custom internal frame
private class MyInternalFrame extends JInternalFrame {

    public MyInternalFrame() {
        super("MyInternalFrame",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        setSize(300, 200);
    }

    public MyInternalFrame(int offsetX, int offsetY) {
        super("MyInternalFrame",
                true, //resizable
                true, //closable
                true, //maximizable
                true);//iconifiable

        setSize(300, 200);
        setLocation(offsetX, offsetY);
    }
}