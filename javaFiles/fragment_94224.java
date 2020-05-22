File inputFile = new File("document.txt"); // document
    Scanner in = new Scanner(inputFile);            

    while (in.hasNext()){

        String input = in.next();
        //input.matches("([^a-zA-Z])"); not required
        System.out.println(input.matches("[a-zA-Z]+")+"\n"+input);

        //if text matches regex, print text
        if (input.matches("[a-zA-Z]+")){
            System.out.println(input);
        }