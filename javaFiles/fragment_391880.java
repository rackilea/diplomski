class Example extends JPanel {

    int x = 0;
    int y = 0;

    Example() {

        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "right");
        getActionMap().put("right", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {

                x++;
                repaint();
            }
        });
    }

    @Override
    public Dimension getPreferredSize() {

        return new Dimension(200, 200);
    }

    @Override
    public void paintComponent(Graphics g) {

        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawRect(x, y, 30, 30);
    }

    public static void main(String args[]) {

        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {

                JFrame frame = new JFrame();
                frame.add(new Example());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}