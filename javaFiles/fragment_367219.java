public void itemStateChanged(ItemEvent event) {
        if(boxComplain.isSelected()) {
           ab=JOptionPane.showInputDialog("Enter Reason of Complain: ");
           ac=JOptionPane.showInputDialog("Enter What The Complain is About: ");
           label4.setText("Complain request");
           boxComplain.removeItemListener(this);
           boxComplain.setSelected(true);
           boxComplain.addItemListener(this);
         }
     }