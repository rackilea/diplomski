@Override
public void actionPerformed(ActionEvent e) {
    System.out.println("tick");
    for(Raindrop r : rain) {
        r.fall();
    }
    repaint(); //repaint in EDT
}