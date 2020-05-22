Random r = new Random();
    int output = 0;
    for (int i = 0 ; i < 3 ; i++){
        output+=(r.nextInt(10)*Math.pow(10, i));
    }
    System.out.println(output);