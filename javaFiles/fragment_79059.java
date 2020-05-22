int x = 20;
    StringBuilder evenNumberStringBuilder = new StringBuilder();
    StringBuilder oddNumberStringBuilder = new StringBuilder();
    for(int i =0 ; i<x+1; i++){
        if(i % 2 == 0)evenNumberStringBuilder.append(i);
        else oddNumberStringBuilder.append(i);
    }

    System.out.println(evenNumberStringBuilder);
    System.out.println(oddNumberStringBuilder);