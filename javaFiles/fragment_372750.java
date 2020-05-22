private ActionListener listener = new ActionListener() {    
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (e.getSource().equals(buttons[i][j])) {
                    if (isStartButton) {
                        startXCoord = i;
                        startYCoord = j;
                    } else {
                        endXCoord = i;
                        endYCoord = j;
                        disableButtons();
                    }
                    isStartButton = !isStartButton;
                    break;
                }
            }
        }
    }
};