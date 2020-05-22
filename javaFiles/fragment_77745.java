public static void processLine(String text) {
    Scanner data = new Scanner(text);
    int tabCount = 0;        
    while (data.hasNext()){
        String str = "hi";
        str = data.next();
        System.out.print(str + " ");
        if (str.equals("{")) {
           tabCount++;
           System.out.println();
           for (int i = 0; i < TAB_SIZE * tabCount; i++){
              System.out.print(" ");
        }
    }   
}