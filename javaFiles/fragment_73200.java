for(int i = 0; i < WINNER_SIZE; i++) {
        winner_fields[i] = new JTextField();
        winner_fields[i].setBounds(212, 30 + (i * 40), 134, 28);
        winners_tab.add(winner_fields[i]);
        winner_fields[i].setColumns(10);
    }