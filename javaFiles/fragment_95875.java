public static void main(String[] args) {

    String input=null, inputs=null;
    int input1 = 0, input2=0;

    boolean err=true;
    do{
        try{
            input = JOptionPane.showInputDialog("Enter first number");
            input1 = Integer.parseInt(input);
            err=false;
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }while(err);

    err=true;
    do{
        try{
            inputs = JOptionPane.showInputDialog("Enter second number");
            input2 = Integer.parseInt(inputs);
            err=false;
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
    }while(err);

    JOptionPane.showMessageDialog(null, "The GCD of two numbers  " + input
            + "and" + inputs + " is: " + findGCD(input1, input2));

}