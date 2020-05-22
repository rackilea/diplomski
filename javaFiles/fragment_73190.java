Scanner scanner = new Scanner(System.in);
    String userInputChar=scanner.next();
    char userChar=userInputChar.charAt(0);      
    int userInputDigit=scanner.nextInt();       
    for(int i=1;i<=userInputDigit;i++){
        char charProcess=userChar;          
        for(int j=(userInputDigit-i)+1,l=userInputDigit;j>=1;j--,l--){              
            for(int k=l;k>=1;k--){
                System.out.print(charProcess);
            }
            charProcess=(char) (charProcess+1);
            System.out.print(" ");              
        }
        System.out.print("\n");
    }
    scanner.close();