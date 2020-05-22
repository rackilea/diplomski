public class GameBoard extends JPanel {

    public void init(){

        MyButtonActionListener actionListener = new MyButtonActionListener();
        /* MULTIPLE BLANK JBUTTONS WHAT DO????????? */
        JButton temp;
        for(int i = 0; i < BOARD_WIDTH*BOARD_HEIGHT; i++){
            temp = new JButton();
            //temp.setActionEvent("a" + i);
            temp.setActionCommand(""+i); // <- Unique Identifier
            temp.addActionListener(actionListener);
            this.add(temp);
        }
    }

    private static class MyButtonActionListener implements ActionListener{

        public void actionPerformed(ActionEvent e){
            String actionCommand = e.getActionCommand();
            // Decide what to do for each button:
            // ...
        }
    }

}