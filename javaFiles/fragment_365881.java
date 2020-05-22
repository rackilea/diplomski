Scanner scanner = new Scanner(System.in);
    String text = scanner.next();
    char[] characters =text.toCharArray(); //create character array of letters
    int square = 80; //length of box

    if(square > 0){
        int index=0;
        for(int i = 0; i<square; i++){
            for(int j = 0; j<square; j++){
                if(i == 0 || j == 0 || i == square-1 || j == square-1)
                    System.out.print("*");
                else{
                    if(index<characters.length&&index<square*square)//if index in bounds
                        System.out.print(characters[index++]);//print next letter
                    else{
                        System.out.print(" ");   //else whitespace
                    }
                }    
            }
            System.out.println();
        }