private class MenuHandler implements ActionListener {
    MainBoard mainBoard;

    MenuHandler(MainBoard mainBoard) {
        this.mainBoard = mainBoard;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit) {
            System.exit(0);
        }else if(e.getSource() == blueBackground) {
            // MainBoard mb = new MainBoard();
            mainBoard.setMainPanel(Color.BLUE);
        }
    }
}