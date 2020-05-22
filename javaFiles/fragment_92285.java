int studentCounter = 0;
while(studentCounter < 10 ){
    String input = JOptionPane.showInputDialog("Enter (1=pass, 2= fail)");
    result = Integer.parseInt(input);
    if(result==1){
            passes++;
            studentCounter++;
    }else if(result==2){
            failures++;
            studentCounter++;
    } else {
        JOptionPane.showMessageDialog(null,"Error input 1 or 2");
    }
}