System.out.println("you have only two chance to get all");
int guessnum[] = new int[2];;        
for (int i = 0; i < guessnum.length; i++) {
    System.out.print((i+1)+" Enter number 1-4 : ");
    int num = sc.nextInt();
    if (num == 1) {            
       System.out.println("not here");
    }
    else if (num == 2) {            
       System.out.println("wow!! you got it");
    }
    else if (num == 3) {            
       System.out.println("not here");

    }
    else if (num == 4) {            
       System.out.println("wow!! you got it");
    }   
    else {            
       System.out.println("number must be 1-4 only, try again");
      --i;
    }
}