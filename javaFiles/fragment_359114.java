public void actionPerformed(ActionEvent e){
    String command=e.getActionCommand();
    switch (command){
        case "New Game":
        solitaire=new Solitaire();
        solitaire.shuffle();
        solitaire.deal();
        solitaire.update();
        break;
    }
}