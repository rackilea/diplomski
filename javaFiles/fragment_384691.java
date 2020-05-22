int input = 0;
Boolean ready = false;
while(!ready){
    try{
        System.out.print("Please Enter your Student ID (Numbers Only):  ");
        Scanner in = new Scanner(System.in);
        input = in.nextInt();
        ready=true;
    }catch(IOException e){
        System.out.err("that was not a number");
    }
}

// now we have input of integer numbers
doRestOfProgram();