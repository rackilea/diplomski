public class buttons2 implements ActionListener{
    static JLabel jlab;

    public void actionPerformed(ActionEvent Ae){

                             jlab.setText(Ae.getActionCommand());

                         }



    public static void main(String args[]){

        buttons2 s = new  buttons2();

        JFrame j = new JFrame("HP");
            j.setSize(300,300);
            j.setLayout(new FlowLayout());
            j.setDefaultCloseOperation(j.EXIT_ON_CLOSE);
            j.setVisible(true);    

            jlab=new JLabel("Here");
            j.add(jlab);

            JButton j1=new JButton("Button1");
            j1.setActionCommand("Your pressed Button 1");

            j1.addActionListener(s);

            j.add(j1);

            JButton j2=new JButton("Button2");
            j2.setActionCommand("Your pressed Button 2");
            j2.addActionListener(s);
            j.add(j2);
       }
   }