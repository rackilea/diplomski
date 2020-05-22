checkBoxMute.addActionListener(
   new ActionListener(){
        public void actionPerformed(ActionEvent ae) {   
          if (checkBoxMute.isSelected()) {
              System.out.println("Muted!");
              player.toggleSound();
          }
          else {
              System.out.println("Unmuted!");
              player.toggleSound();
          } 
       }
   });