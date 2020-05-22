private void exitForm(java.awt.event.WindowEvent evt) {                          
     //System.exit(0); which was used 
     // to fullfill your requirement you need to write below code
     this.dispose();// here [this] keyword means your current frame
     //OR simply you can use this.setVisible(false); instead of this.dispose();
     myPreviousFrame.setVisible(true); // this will displays your login frame
}