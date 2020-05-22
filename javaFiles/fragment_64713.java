clr.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e)
        {
            Color c = JColorChooser.showDialog(ta1, "ColorChooserDemo", null);
            ta1.setForeground(c);
        }
    });