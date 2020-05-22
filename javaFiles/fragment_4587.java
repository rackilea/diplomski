public static void main(String[] args) {

    //bugChecking bc = new bugChecking();
    float i = 0.0f;
    String tmp = "";

    Scanner in = new Scanner(System.in);

    System.out.println("Please enter a positive integer");

    while (true) {

        tmp = in.nextLine();//read line
        tmp = tmp.replaceAll("\\s+", "");//get rid of spaces

        if (tmp.isEmpty()) {//wrong input
            System.err.println("Please enter a number greater than 0.");
        } else {//correct input

            try{//attempt to convert sring to float
            i = new Float(tmp);
            }catch(NumberFormatException nfe) {    
                System.err.println(nfe.getMessage());
            }

            System.out.println(i);
            break;//got correct input halt loop
        }

    }
    in.close();
}