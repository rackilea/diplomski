public class TestGui {

    public TestGui() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MidPanel midPanel = new MidPanel();
        TopPanel topPanel1 = new TopPanel();
        TopPanel topPanel2 = new TopPanel();
        TopPanel topPanel3 = new TopPanel();

        JLabel appName = new JLabel("MyApplication");
        JLabel verNum = new JLabel("version 1.0");
        Font verFont = new Font("Tahoma", Font.BOLD, 11);
        Font nameFont = new Font("Tahoma", Font.BOLD, 14);

        GridBagConstraints gbc = new GridBagConstraints();

        appName.setForeground(Color.WHITE);
        appName.setFont(nameFont);
        verNum.setForeground(new Color(0xFF9f9f9f));
        verNum.setFont(verFont);

        //add program name and version number
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        midPanel.add(appName, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);
        midPanel.add(verNum, gbc);

        //add 3 example top panels to midpanel
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(1,2,1,2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        midPanel.add(topPanel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.insets = new Insets(1,2,1,2);
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        midPanel.add(topPanel2, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(1,2,1,2);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        midPanel.add(topPanel3, gbc);

        //add panel to push other panels to top
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.weighty = 1.0;
        JPanel invisPanel = new JPanel();
        invisPanel.setOpaque(false);
        midPanel.add(invisPanel, gbc);

        frame.getContentPane().add(midPanel);
        frame.pack();
        frame.setVisible(true);
    }

    //test it out
    public static void main(String[] args) {
        new TestGui();
    }

    //class for the top 3 panels
    private class TopPanel extends JPanel {

        private int maxLength;
        private boolean cyclic;


        public TopPanel() {
            super(true);
            initComponents();
            setOpaque(false);
            cyclic = true;
            maxLength = 0;
        }


        @Override
        public void paintComponent(Graphics g) {
            if(isOpaque()) {
                super.paintComponent(g);
                return;
            }

            int width = getWidth();
            int height = getHeight();

            GradientPaint paint = null;

            //Color top = new Color(50, 50, 50);
            //Color btm = new Color(19, 19, 19);

            Color top = new Color(0xFF222222);
            Color btm = new Color(0xFF0c0c0c);

            paint = new GradientPaint(width / 2, 0, top, width / 2, maxLength > 0 ? maxLength : height, btm, cyclic);

            if(paint == null) {
                throw new RuntimeException("Invalid direction specified in GamerTagPanel");
            }

            Graphics2D g2d = (Graphics2D) g;
            Paint oldPaint = g2d.getPaint();
            g2d.setPaint(paint);
            g2d.fillRect(0, 0, width, height);
            g2d.setPaint(oldPaint);

            super.paintComponent(g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 200);
        }

        @Override
        public void paintBorder(Graphics g) {
            Dimension d = getSize();

            g.setColor(new Color(0xFF484848));
            g.drawRoundRect(1, 1, d.width-3, d.height-3, 10, 10);

            g.setColor(Color.BLACK);
            g.drawRoundRect(0, 0, d.width-1, d.height-1, 10, 10);
        }        

        private void initComponents() {
            GridBagConstraints gbc;
            JLabel jLabel1 = new JLabel();
            JLabel jLabel2 = new JLabel();

            setBorder(BorderFactory.createLineBorder(new Color(204,204,204)));
            setLayout(new GridBagLayout());

            jLabel1.setFont(new Font("Tahoma", Font.BOLD, 11));
            jLabel1.setForeground(new Color(255, 255, 255));
            jLabel1.setText("Scanning...");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets = new Insets(5, 5, 5, 5);
            add(jLabel1, gbc);

            jLabel2.setFont(new java.awt.Font("Tahoma", Font.BOLD, 11));
            jLabel2.setForeground(new Color(0xFF9f9f9f));
            jLabel2.setText("C:\\Directory\\Folder\\SubFolder\\SpecificFolder\\File.file");
            gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.weightx = 1.0;
            gbc.insets = new Insets(5, 5, 5, 5);
            add(jLabel2, gbc);
        }
    }

    public class MidPanel extends JPanel {

        private int maxLength;
        private boolean cyclic;

        public MidPanel() {
            setLayout(new GridBagLayout());
            setOpaque(false);
            maxLength = 0;
            cyclic = false;
        }


//        public void paintBorder(Graphics g) {
//            g.setColor(Color.RED);
//            Rectangle bounds = getBounds();
//            g.drawRoundRect(bounds.x, bounds.y, bounds.width, bounds.height, 10, 10);
//        }

        @Override
        public void paintComponent(Graphics g) {
            if(isOpaque()) {
                super.paintComponent(g);
                return;
            }

            int width = getWidth();
            int height = getHeight();

            GradientPaint paint = null;

            Color top = new Color(0xFF282828);
            Color btm = new Color(0xFF0e0e0e);

            paint = new GradientPaint(width / 2, 0, top, width / 2, maxLength > 0 ? maxLength : height, btm, cyclic);

            if(paint == null) {
                throw new RuntimeException("Invalid direction specified in GamerTagPanel");
            }

            Graphics2D g2d = (Graphics2D) g;
            Paint oldPaint = g2d.getPaint();
            g2d.setPaint(paint);
            g2d.fillRect(0, 0, width, height);
            g2d.setPaint(oldPaint);
            super.paintComponent(g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 400);
        }
    }
}