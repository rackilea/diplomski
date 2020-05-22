btnSave = new JButton ("Save");
    btnSave.setBounds(130, 350, 100, 20);
    btnSave.setForeground(Color.blue);
    btnSave.addActionListener(new SaveHandler());
    panel.add (btnSave);
    btnSave.setVisible(true);