@Override
public void mouseClicked(MouseEvent e) {
    for (int i = 0; i < 7; i++) {
        if (e.getSource() == jLabelArr[i]) {
            System.out.println("You clicked on JLabel" + i);
            jLabelArr[i].setIcon(new ImageIcon(learningSwing.imageTwo()));
        }
    }
}