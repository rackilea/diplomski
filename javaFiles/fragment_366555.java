public static void main(String[] args) throws IOException {
    byte binary[] = new byte[127];   //declared a byte array for input value
    int power = 2, formula = 0;      //declared the power and the formula as int

    System.out.print("Enter Binary: "); //prints "Enter binary:"
    System.in.read(binary);          //inserts the input in the binary array
    Integer bin = Integer.parseInt(new String(binary).trim()); //converts the input value to int for another conversion

    String b = Integer.toString(bin); //converts the int bin to string
    Integer num; //num variable gets the value of last string (should be anyway)
    System.out.println("The Decimal Value of " + bin + " is ");

    for(int i = b.length(); i > 0; i--){ 
        power = 1;
        num = Integer.parseInt(Character.toString(b.charAt(i-1)));

        for(int a = i; a < b.length(); a++){ //the condition
            power = power*2;        //as the loop goes, if 2^3 then it should be 8
        }

        formula = formula + (num * (power)); //as the given formula above, this is what I did
        System.out.println("power: " + power);//if you want reference, I left it here
        System.out.println("formula: " +formula);
        System.out.println("num: " + num);
    }
    System.out.print(formula);
}