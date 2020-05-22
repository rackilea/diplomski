public static void main(String[] args) {

        String Boundary1 = JOptionPane.showInputDialog(null, "Please enter the first boundary of the multiplication table.");
        String Boundary2 = JOptionPane.showInputDialog(null, "Please enter the second boundary of the multiplication table.");

        int X = Integer.parseInt(Boundary1);
        int Y = Integer.parseInt(Boundary2);
        int j = 1;
        String Result = "";
        int x = 1;

        while (x <= X) {
            for (int i = 1; i <= Y; i++) {
                j = i * x;
                Result = Result + j + "\t";
            }
            x++;
            Result = Result + "\n";
        }
        JTextArea jt=new JTextArea(Result);
        jt.setEditable(false);
        jt.setOpaque(false);
        jt.setTabSize(3);
        JOptionPane.showMessageDialog(null, jt);
    }