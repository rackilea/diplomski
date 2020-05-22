package jzoom.test;

import ...

public class TestFinal {
    public static void main(String[] args) {
        new TestFinal();
    }

    public TestFinal() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (UnsupportedLookAndFeelException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setMinimumSize(new Dimension(400,500));
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JLayer<JComponent> layer;
        private TransformUI layerUI;
        private JPanel content;
        private AffineTransform transform = new AffineTransform();
        private ZoomPanel zoomPanel;

        public TestPane() {

            content = new JPanel(new GridBagLayout());
            // content = new JPanel(new XYLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;
            gbc.weighty = 0;
            gbc.weightx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            JLabel label = new JLabel("Hello");
            JTextField field = new JTextField("World", 20);

            content.add(label, gbc);
            gbc.weightx = 1;
            content.add(field, gbc);
            // content.add(label, new XYConstraints(50, 20, 50, 22));
            // content.add(field, new XYConstraints(100, 20, 200, 22));

            gbc.gridy++;
            gbc.gridwidth = 2;

            final JSlider slider = new JSlider(100, 200);
            slider.setValue(100);
            slider.addChangeListener(new ChangeListener() {

                @Override
                public void stateChanged(ChangeEvent e) {
                    int value = slider.getValue();
                    double scale = value / 100d;
                    zoomPanel.setScale(scale);
                }
            });
            content.add(slider, gbc);
            // content.add(slider, new XYConstraints(75, 50, 200, 50));

            gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            JTextArea textArea = new JTextArea();
            textArea.setEditable(true);
            textArea.setText(
                    "pollofritto\npalma\npalmipedone\ncaccoletta\namammata\na\nasd\nasdgfag\nasdafa\nasdfasf\nadsfasdf\nadfadsf\nadsfdasf\nasdfdas\npollofritto\npalma\npalmipedone\ncaccoletta\namammata\na\nasd\nasdgfag\nasdafa\nasdfasf\nadsfasdf\nadfadsf\nadsfdasf\nasdfdas");
            // textArea.setPreferredSize(new Dimensions());
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.setPreferredSize(new Dimension(200, 75));
            content.add(scrollPane, gbc);

            gbc.gridy++;
            gbc.gridwidth = 2;
            gbc.weighty = 0;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
            JComboBox petList = new JComboBox(petStrings);
            content.add(petList, gbc);

            JButton zoomIn = new JButton("Zoom In");
            // zoomIn.addMouseListener(new ZoomMouseListener());
            zoomIn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // System.out.println("FIRST");
                    // layerUI.zoomIn();

                    //double zoom = transform.getScaleX();
                    //transform.setToIdentity();
                    //transform.scale(zoom + 0.1, zoom + 0.1);
                    zoomPanel.zoomIn();

                    // jLayer.repaint();
                }
            });

            JButton zoomOut = new JButton("Zoom Out");
            zoomOut.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    zoomPanel.zoomOut();

                    //double zoom = transform.getScaleX();
                    //transform.setToIdentity();
                    //transform.scale(zoom - 0.1, zoom - 0.1);
                    // jLayer.repaint();
                }
            });
            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 0;
            gbc.anchor = GridBagConstraints.LINE_END;

            // content.add(zoomOut, new XYConstraints(50, 120, 100, 25));
            // content.add(zoomIn, new XYConstraints(170, 120, 100, 25));

            JPanel button = new JPanel();
            button.setLayout(new BoxLayout(button, BoxLayout.LINE_AXIS));
            button.add(zoomOut);
            button.add(zoomIn);
            gbc.fill = GridBagConstraints.NONE;
            content.add(button, gbc);

            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            zoomPanel = new ZoomPanel();
            zoomPanel.setView(content);
            add(zoomPanel);
        }
    }
}