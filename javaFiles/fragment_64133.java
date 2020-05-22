public static void search(){
    search = JOptionPane.showInputDialog(null,"Enter a student ID");
    for(int i = 0;i < studentID.length;i++){
        if(studentID[i] == Integer.parseInt(search)){
            JOptionPane.showMessageDialog(null, studentID[i]);
            return;
        }
    }
    OptionPane.showMessageDialog(null,"NOT FOUND!!!");
}