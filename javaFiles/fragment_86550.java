public class DoodleGodTestOrganized {

JFrame frame = new JFrame("DoodleGod");
public static JToggleButton waterButton = new JToggleButton("Water");
public static JToggleButton fireButton = new JToggleButton("Fire");
public static JToggleButton steamButton = new JToggleButton("Stream");


public DoodleGodTestOrganized(){
    frame();

}

public void frame(){
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(600, 340);
    frame.setTitle("Doogle God");
    frame.setLocationRelativeTo(null);
    frame.setResizable(true);
    frame.setVisible(true);

    JPanel panel = new JPanel();
    panel.add(waterButton);
    panel.add(fireButton);
    panel.add(steamButton);
    steamButton.setVisible(false);
    panel.setVisible(true);
    frame.add(panel, BorderLayout.NORTH);
    frame.setVisible(true);

}


public static void main(String[] args) {
    new DoodleGodTestOrganized();

    //Created actionListener for the waterbutton
    waterButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(waterButton.isSelected() && fireButton.isSelected()){
                steamButton.setVisible(true);
            }else{
                steamButton.setVisible(false);
            }
        }
    });


//Actionlistener for the fireButton
    fireButton.addActionListener(new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e){
            if(waterButton.isSelected() && fireButton.isSelected()){
                steamButton.setVisible(true);
            }else{
                steamButton.setVisible(false);
            }
        }
    });

 }
}