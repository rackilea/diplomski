Random r = new Random();
    String output = "";
    for (int i = 0 ; i < 3 ; i++){
        output+=r.nextInt(10);
    }
    int outputInt = Integer.parseInt(output);