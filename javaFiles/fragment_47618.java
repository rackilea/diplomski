public class PaintLab extends JPanel {
    private JButton circle, square;
    private DrawingPanel drawingPanel;//declare drawingPanel as field 

    public PaintLab() {
        circle = new JButton("Draw Circle");
        circle.addActionListener(new ButtonListener());
        square = new JButton("Draw Square");
        square.addActionListener(new ButtonListener());
        JPanel buttonPanel = new JPanel();
        /*JPanel already declared as field*/  
        drawingPanel = new DrawingPanel(400, 400);
        add(drawingPanel);
        BoxLayout bX = new BoxLayout(buttonPanel, BoxLayout.X_AXIS);

        buttonPanel.setLayout(bX);
        buttonPanel.add(circle);
        buttonPanel.add(square);

        add(buttonPanel);
    }

    private class DrawingPanel extends JPanel { // outer

            //code removed
        }

        public void paintComponent(Graphics g) { // inner
            //code removed     
        }

        //add setters 
        void setPaintFlag(boolean paintFlag) {
            this.paintFlag = paintFlag;
        }

        void setTheMode(int theMode) {
            this.theMode = theMode;
        }
    }

    class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            if (event.getSource() == circle) {
                drawingPanel.setPaintFlag(true);
                drawingPanel.repaint();
            } else if (event.getSource() == square) {
                drawingPanel.setPaintFlag(false);
                drawingPanel.repaint();
            }
        }
    }
}