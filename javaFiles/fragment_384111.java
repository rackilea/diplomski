JToggleButton edit = new JToggleButton("Edit");
        auxButtonsLayout.setConstraints(edit, c);
        edit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                commanderName.setEnabled(!commanderName.isEnabled());
            }
        });
        auxButtonPanel.add(edit);