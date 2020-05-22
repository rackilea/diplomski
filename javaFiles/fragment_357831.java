public class MyPanel extends JPanel {

    public MyPanel() {
        // ...
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    // Handle left-click
                } else if (e.getButton() == MouseEvent.BUTTON2) {
                    // Handle right-click
                }
            }
        });
    }
}