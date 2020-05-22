public MainFrame() {
    public void actionPerformed(ActionEvent ev){
         FrameOne frameOne = new FrameOne(userField.getText(),passField.getText());
         frameOne.setVisible(true);
    } 
} 


public class FrameOne extends JFrame
{
    private String user;

    private String pass;

    public FrameOne(String usr, String pas){

        this.user=usr;

        this.pass=pas;

       //components

   }
}