public void actionPerformed(ActionEvent a){
    JPanel panel = Game.Game();
    this.remove(menu);
    this.add(panel);   
    this.revalidate();
}