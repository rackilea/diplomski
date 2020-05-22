public void mouseClicked(MouseEvent e) {
    ...

    //initial setup
    if (circleColor[row][col] == null) {
        circleColor[row][col] = new Color(0);
    }

    System.out.println("Cell color: " + circleColor[row][col]); //will let you see whats happening
    if (circleColor[row][col].equals(Color.getHSBColor(0,0,0))) {
        circleColor[row][col] = new Color(0,223,197);
    } else {
        circleColor[row][col] = new Color(0) ;
    }

    repaint(); // redraw the panel by calling the paintComponent method.
}