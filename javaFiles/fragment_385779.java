public static boolean Prompt(BufferedReader br){
    do{
        System.out.print("Do you want to cotinue? \nPress y or n\n");
        char c = 'a';
        try {

         c = (char) br.read();//System.in.read();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(c=='y') return true;
        if(c=='n') return false;

    }while(true);
}