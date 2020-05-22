JButton[] buttons = new JButton[4];
    for(int i = 0; i < buttons.length; i++){
        switch (i) {
            case 0:
                buttons[i] = new JButton("Red");
                break;
            case 1:
                buttons[i] = new JButton("Blue");
                break;
            case 2:
                buttons[i] = new JButton("Green");
                break;
            case 3:
                buttons[i] = new JButton("Black");
                break;
            default:
                break;
        }
        panel.add(buttons[i]);
    }