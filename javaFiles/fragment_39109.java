public static void main(String args[]) {
                new Main().setVisible(true);
                String incomming = Arrays.toString(args).replace("[", "");
                String incommingF = incomming.replace("]", "");
                JOptionPane.showMessageDialog(null, incommingF) ;
    }