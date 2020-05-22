public static void main (String []args){

    do{
        //Do some stuff
        System.out.println("Do you want try again? [y/n]");
        char c = (char) System.in.read();
    }while(c == 'y');
}