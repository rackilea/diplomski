while (true) {
    String input = in.next();

    if (input.equals("Bye!")){
        System.out.println("Bye!"); 
        break;           
    }
    int output = random.nextInt(6);
    System.out.println(answer[output]);
 }