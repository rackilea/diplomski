public class Main {//change it as you wish
    final static String file = "Your file path";
    public static void main(String[] args) {
        final JTextField UserName = new JTextField("Enter Your UserName");
        final JTextField Password = new JTextField("Enter Your Password");
        JButton Login = new JButton ("Login"); 


        Login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                String uName = UserName.getText();
                String pass = Password.getText();
                checkUserPass(uName, pass);//check them as you want

            }
        });
    }
    static boolean checkUserPass(String uName, String pass) {
        try(BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            // I assume your file contains just a line like      username:password
            if ((line = br.readLine()) != null) {
                // process the line.


                String[] tmp = line.split(":");
                if (tmp[0].equals(uName) && tmp[1].equals(pass)) {
                    return true;
                }
                return false;
            }
        }catch (IOException e) {

        }
        return false;

    }
}