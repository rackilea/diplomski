addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int w = getWidth();
        int h = getHeight();
        selectedCell = null;
        for (int col = 0; col < 3 && selectedCell == null; col++) {
            for (int row = 0; row < 3; row++) {
                int x = (w / 3) * col;
                int y = (h / 3) * row;
                Rectangle cell = new Rectangle(x, y, w / 3, h / 3);
                if (cell.contains(e.getPoint())) {
                    System.out.println("In");
                    selectedCell = cell;
                    repaint();
                    break;
                }
            }
        }
    }
});