public void actionPerformed(ActionEvent e) {
    for (int i = 0; i < radioButtons.length; i++) {
         if (radioButtons[i].isSelected()) {
             System.out.println("Button " + i + " was selected!");
             // Optionally, you might want to put a break; here
         }
    }
}