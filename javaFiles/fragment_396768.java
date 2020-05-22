Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    boolean hasOne = false;
    int rem;

    for(int i = n; i > 0; i = i / 10)
    {   

       rem = i % 10;

        if(rem == 1)
            hasOne = true;
    }
    if(hasOne){
        System.out.println("Has 1");
    }else{
        System.out.println("Has No 1");
    }