JRadioButton[][] jRadioButtons = new JRadioButton[8][];
        ButtonGroup bg = new ButtonGroup();
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 8));
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JRadioButton btn = new JRadioButton();
                btn.addActionListener(listener);
                btn.setName("Btn[" + i + "," + j + "]");
                bg.add(btn);
                panel.add(btn);
                // can be used for other operations
                jRadioButtons[i][j] = btn;
            }
        }