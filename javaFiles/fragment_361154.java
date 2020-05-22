public void actionPerformed(final ActionEvent e) {
    Thread t = new Thread() {
        public void run() {
            //jTextArea1.setText(null);
            if (box1.isSelected()) {
                System.out.println("1 is selected");
                willRerollDiceOne = true;
            }
            else {
                //System.out.println("1 not selected");
                willRerollDiceOne = false;
            }
            if (box2.isSelected()) {
                System.out.println("2 is selected");
                willRerollDiceTwo = true;
            }
            else {
                //System.out.println("2 not selected");
                willRerollDiceTwo = false;
            }
            if (box3.isSelected()) {
                System.out.println("3 is selected");
                willRerollDiceThree = true;
            }
            else {
                //System.out.println("3 not selected");
                willRerollDiceThree = false;
            }
            if (box4.isSelected()) {
                System.out.println("4 is selected");
                willRerollDiceFour = true;
            }
            else {
                //System.out.println("4 not selected");
                willRerollDiceFour = false;
            }
            if (box5.isSelected()) {
                System.out.println("5 is selected");
                willRerollDiceFive = true;
            }
            else {
                //System.out.println("5 not selected");
                willRerollDiceFive = false;
            }

            if ("menu".equals(area)) {
                if(e.getSource() == textYes){
                    start("yes");
                }
                if(e.getSource() == textNo){
                    start("no");
                }
            }
            if ("choiceReroll".equals(area)) {
                if(e.getSource() == textYes){
                    choiceReroll = "yes";
                }
                if(e.getSource() == textNo){
                    choiceReroll = "no";
                }
            }
        }
    };
    t.start();

}