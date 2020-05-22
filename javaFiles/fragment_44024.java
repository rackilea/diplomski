public MainMenu(int WW, int WH){
    // WW = window width
    // WH = widow height
    // this.setLocation(0, 0);
    // this.setSize(WW, WH);

    setLayout(new BorderLayout());
    background = new Background(WW, WH);
    this.add(background, BorderLayout.CENTER);
}