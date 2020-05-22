class MainPanel extends JPanel {

    private List<Rectangle> rectangles = new ArrayList<Rectangle>();

    private void addRectangle(Rectangle rectangle) {
      rectangles.add(rectangle);
    }

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      Graphics2D g2 = (Graphics2D) g;
      for (Rectangle rectangle : rectangles) {
        g2.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
      }
    }

  }