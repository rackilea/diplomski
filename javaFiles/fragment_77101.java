public class ShowMeTheScreenSize {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                System.out.println("VirtualBounds = " + getVirtualBounds());

                for (int index = 0; index < getScreenDeviceCount(); index++) {
                    System.out.println("[" + index + "] Device bounds = " + getScreenDeviceBounds(index));
                }

                System.exit(0);
            }
        });
    }

    public static int getScreenDeviceCount() {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();

        return ge.getScreenDevices().length;

    }

    public static Rectangle getVirtualBounds() {

        Rectangle bounds = new Rectangle(0, 0, 0, 0);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {

            bounds.add(gd.getDefaultConfiguration().getBounds());

        }

        return bounds;

    }

    public static Rectangle getScreenDeviceBounds(int index) {

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();

        return lstGDs[index].getDefaultConfiguration().getBounds();

    }
}