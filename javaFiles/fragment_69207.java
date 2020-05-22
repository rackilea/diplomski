public class CellPane extends JPanel {

    private Insets insets = new Insets(0, 0, 0, 0);

    public CellPane() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point p = e.getPoint();
                int quadrant = 0;
                if ((p.x >= 0 && p.x < 11) && p.y >= 0 && p.y < 41) {
                    quadrant = 1;
                } else if ((p.x >= 0 && p.x < 41) && p.y >= 40) {
                    quadrant = 2;
                } else if ((p.x >= 10 && p.x < 51) && p.y < 11) {
                    quadrant = 3;
                } else if ((p.x > 40 && p.y > 10)) {
                    quadrant = 4;
                } else {
                    quadrant = 5;
                }

                if (e.getButton() == MouseEvent.BUTTON1) {
                    if (quadrant == 1) {
                        System.out.println("Left");
                        insets.left = insets.left == 0 ? 3 : 0;
                    }
                    if (quadrant == 2) {
                        System.out.println("Bottom");
                        insets.bottom = insets.bottom == 0 ? 3 : 0;
                    }
                    if (quadrant == 3) {
                        System.out.println("Top");
                        insets.top = insets.top == 0 ? 3 : 0;
                    }
                    if (quadrant == 4) {
                        System.out.println("Right");
                        insets.right = insets.right == 0 ? 3 : 0;
                    }

                    Border border = getBorder();
                    if (border instanceof CompoundBorder) {
                        border = ((CompoundBorder) border).getOutsideBorder();
                    }
                    setBorder(new CompoundBorder(border, new MatteBorder(insets, Color.BLUE)));

                    if (quadrant == 5) {
                        //setBorder(new MatteBorder(3,3,3,3, Color.BLUE));      //Click in the middle to highlight all sides of a square
                    }

                }
            }

        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(50, 50);
    }
}