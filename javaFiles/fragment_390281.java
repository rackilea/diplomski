public class TestApplet extends JApplet {

    public void init() {

        System.out.println("Init..." + EventQueue.isDispatchThread());

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                createGUI();
            }
        });

    }

    public void start() {

        System.out.println("Start..." + EventQueue.isDispatchThread());

    }

    public void createGUI() {

        URL documentBase = getDocumentBase();

        System.out.println(documentBase);
        System.out.println(getCodeBase());

//        file:.../build/TestApplet.html
//        file:.../build/classes/        
        Image image = getImage(documentBase, "MT-vol-6-STOP-image-Kogumiko-megatokyo-11434773-1559-1852.jpg");

        System.out.println("image = " + image);

        getContentPane().add(new GUIThing(image));
    }

    public class GUIThing extends JPanel {

        Image image;

        public GUIThing(Image i2) {
            image = i2;
        }

        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 = (Graphics2D) g;
            g2.drawImage(image, 0, 0, this);

            g2.setColor(Color.RED);
            g2.drawLine(0, 0, getWidth(), getHeight());

        }
    }

}