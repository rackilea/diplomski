public GamePanel() {
    secondSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,splitTableHand, chatPanel);

    secondSplit.setOneTouchExpandable(true);
    secondSplit.setDividerLocation(150);
    this.setSize(1280, 720);
    this.setResizable(false);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    //this.pack();
    this.setVisible( true );
    getContentPane().add( secondSplit );
}