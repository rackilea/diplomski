public class A implements ActionListener {

    public static final String MY_STRING = "This is a string"; // can be private also

    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println(MY_STRING);
    }
}