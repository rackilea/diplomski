public class ViewScroller {

  public ViewScroller() {
    JFrame frame = new JFrame("ViewScroller");
    final ImageIcon image = new ImageIcon("path\\to\\my\\image");
    JLabel label = new JLabel(image);
    final JScrollPane scrollPane = new JScrollPane(label);
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

    JButton left = new JButton("<");
    left.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Point p = scrollPane.getViewport().getViewPosition();
        p.x = p.x < 10 ? 0 : p.x - 10;
        scrollPane.getViewport().setViewPosition(p);
      }
    });

    JButton right = new JButton(">");
    right.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Point p = scrollPane.getViewport().getViewPosition();
        int offset = p.x + scrollPane.getViewport().getWidth();
        p.x = offset + 10 > image.getIconWidth() ? p.x : p.x + 10;
        scrollPane.getViewport().setViewPosition(p);
      }
    });

    frame.add(right, BorderLayout.EAST);
    frame.add(left, BorderLayout.WEST);
    frame.add(scrollPane, BorderLayout.CENTER);

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 400);
    frame.setVisible(true);
  }
}