String[] buttons = {
        "1", "2", "3", "/", "4",
        "5", "6", "*", "7", "8", "9", "-", "0", ".", "=", "+"
    };

    Action[] allActions = new Action[buttons.length];

    for ( i = 0; i < buttons.length; i++) {

        allActions[i] = new ButtonAction(buttons[i],i);

        JButton button = new JButton(allActions[i]);

           panel.add(button);


        }