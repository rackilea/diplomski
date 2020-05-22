JButton reset = new JButton("Reset");
    reset.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            for(Component c : toolBarTop.getComponents()){
                if(c instanceof JCheckBox){
                    JCheckBox checkBox = (JCheckBox) c;
                    checkBox.setSelected(true);
                }
            }
        }
    });