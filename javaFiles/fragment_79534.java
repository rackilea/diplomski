public static void leer() throws IOException {  
    Scanner s = new Scanner(new File("init.txt"));  
    while (s.hasNext()) {
        //Read these at the top, so we don't read them twice, and consume too many tokens 
        String item = s.next();
        int i = s.nextInt();  
        int j = s.nextInt();

        if(item == "Wall") {  
            Tablero[i][j] = new Wall();
        }  
        else if(item =="Ghost") {  
            Tablero[i][j]=new Ghost();  
        }  
    }  
}