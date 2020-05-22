static class MyInternalFrame extends JInternalFrame implements
        ComponentListener {

    public MyInternalFrame() {
        super("iFrame", true, // resizable
                true, // closable
                true, // maximizable
                true);// iconifiable
        setSize(300, 300);
        addComponentListener(this);

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentResized(ComponentEvent e) {
        System.out.println("Resized");
        System.out.println("Width: " + getWidth());
        System.out.println("Height: " + getHeight());
        System.out.println();

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }


}