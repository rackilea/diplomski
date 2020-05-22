@Override
public void actionPerformed(ActionEvent ae) {
    System.out.println("Button 1 was pressed");
    CurrentClicks++;
    System.out.println("Current Clicks: " + CurrentClicks);
    repaint();
}