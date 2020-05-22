@Override
public void keyReleased(KeyEvent e)
{
    typeText();
    /*new TwoSecondDelay (Integer.toString(name));
    name++;
    client.setText(server.getText());*/

}

public void typeText(){
    ActionListener listener = new ActionListener(){
        public void actionPerformed(ActionEvent event){
            client.setText(server.getText());
        }
    };
    Timer timer = new Timer(2000, listener);
    timer.setRepeats(false);
    timer.start();
}