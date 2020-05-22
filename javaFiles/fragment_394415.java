public class MainMenuButtonHandler implements ActionListener {

    private JButton exitButton;

    public void setExitButton(JButton exitButton){
        this.exitButton = exitButton;
    }

    @Override public void actionPerformed(ActionEvent e) {
        //Do your work and invoke Click of exitButton
        this.exitButton.doClick();
    }
}