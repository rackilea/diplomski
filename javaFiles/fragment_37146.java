public class MoveMe {

    public static void main(String[] args) {
        new MoveMe();
    }

    public MoveMe() {
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
                frame.add(new MoveMePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class MoveMePane extends JLayeredPane {

        public MoveMePane() {
            int width = 400;
            int height = 400;
            for (int index = 0; index < 10; index++) {
                String text = "Label " + index;
                JLabel label = new JLabel(text);
                label.setSize(label.getPreferredSize());

                int x = (int) Math.round(Math.random() * width);
                int y = (int) Math.round(Math.random() * height);
                if (x + label.getWidth() > width) {
                    x = width - label.getWidth();
                }
                if (y + label.getHeight() > width) {
                    y = width - label.getHeight();
                }
                label.setLocation(x, y);
                add(label);
            }

            MoveMeMouseHandler handler = new MoveMeMouseHandler();
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }

    public class MoveMeMouseHandler extends MouseAdapter {

        private int xOffset;
        private int yOffset;
        private JLabel draggy;
        private String oldText;

        @Override
        public void mouseReleased(MouseEvent me) {
            if (draggy != null) {
                draggy.setText(oldText);
                draggy.setSize(draggy.getPreferredSize());
                draggy = null;
            }
        }

        public void mousePressed(MouseEvent me) {
            JComponent comp = (JComponent) me.getComponent();
            Component child = comp.findComponentAt(me.getPoint());
            if (child instanceof JLabel) {
                xOffset = me.getX() - child.getX();
                yOffset = me.getY() - child.getY();

                draggy = (JLabel) child;
                oldText = draggy.getText();
                draggy.setText("What a drag");
                draggy.setSize(draggy.getPreferredSize());
            }
        }

        public void mouseDragged(MouseEvent me) {
            if (draggy != null) {
                draggy.setLocation(me.getX() - xOffset, me.getY() - yOffset);
            }
        }
    }
}