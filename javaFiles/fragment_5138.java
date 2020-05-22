public void actionPerformed(ActionEvent evt) {
    java.util.Timer timer = new java.util.Timer();
    timer.schedule(new java.util.TimerTask() {
        public void run() {
            if (!preforming){
                preforming = true;
                String newline = "\n";
                String dungeonName = "Star Light";


                String input = textField.getText();   //Text from Input
                textArea.append(dungeonName + ": " + input + newline);     //Add "text" to bottom of console
                String[] output = {
                    "Twinkle twinkle little star.",
                    "How I wonder what you are.",
                    "Up above the world so high."
                };


                //print everything in array output, char by char, with 2-3 seconds after each
                for (int i = 0; i < output.length; i++){
                    String printThis = output[i];

                    if (printThis.length() > 0){
                        for (int j = 0; j < printThis.length(); j++){
                            String printChar = printThis.substring(j, j+1);
                            textArea.append(printChar);
                            //System.out.print(printChar);
                            try{
                                Thread.sleep(25);
                            } catch (InterruptedException e) {
                                System.out.print("Error ");
                            }
                 /*try { //useless
                    Thread.sleep(200);
                 } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                 }*/
                        }
                    }
                    textArea.append("" + newline);
                }


                //cleaning up input bar
                textField.setText("");
                textField.selectAll();
                //Make sure the new text is visible, even if there
                //was a selection in the text area.
                textArea.setCaretPosition(textArea.getDocument().getLength());
                preforming = false;
            }
        }
    }, 1);
}