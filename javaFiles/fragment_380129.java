public class TestLayout09 {

    public static void main(String[] args) {
        new TestLayout09();
    }

    public TestLayout09() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new LayoutPane());
                frame.setBackground(Color.WHITE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class LayoutPane extends JPanel {

        public LayoutPane() {
            Border outline = BorderFactory.createLineBorder(Color.black);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            // I'm not sure this really is what you want, but I may be mistaken
//            gbc.weighty = 1.0;
//            gbc.weightx = 1.0;

            JLabel unitLbl = new JLabel("Unit");
            unitLbl.setBorder(outline);
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.ipadx = 30;
            gbc.ipady = 10;
            gbc.anchor = GridBagConstraints.WEST;
            add(unitLbl, gbc);

            JLabel typeLbl = new JLabel("Type");
            typeLbl.setBorder(outline);
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.ipadx = 30;
            gbc.ipady = 10;
            add(typeLbl, gbc);

            JTextField unitField = new JTextField();
            typeLbl.setBorder(outline);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.ipadx = 30;
            gbc.ipady = 10;
            gbc.anchor = GridBagConstraints.EAST;
            add(unitField, gbc);

            String[] type = {"All", "Verb", "Noun", "Adjective"};
            JComboBox<String> comboBox = new JComboBox<String>(type);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.ipadx = 30;
            gbc.ipady = 10;
            add(comboBox, gbc);

            JButton btn = new JButton("Test");
            gbc.gridx = 3;
            gbc.gridy = 0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.gridheight = 2;
            add(btn, gbc);
        }
    }
}