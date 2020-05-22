combo.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                JOptionPane.showMessageDialog(null, "selected: " + combo.getItemAt(combo.getSelectedIndex()));
            }

        });