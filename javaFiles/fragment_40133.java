public static void main(String[] args) {
    final JFrame frame = new JFrame("Test");
    final ImageComponent imageComponent = new ImageComponent();

    frame.add(new JButton(new AbstractAction("Load") {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser c = new JFileChooser(new File("."));
            if (c.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
                try {
                    imageComponent.set(ImageIO.read(c.getSelectedFile()));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }), BorderLayout.NORTH);
    frame.add(new JScrollPane(imageComponent), BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);
    frame.setVisible(true);
}