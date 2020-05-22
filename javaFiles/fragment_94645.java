public static void printPerLine(int n, String string){
        for (int i = 0; i < string.length(); i++) {
            if(i>1 && i%n == 0){
                System.out.println();
            }
            System.out.print(string.charAt(i));
        }
    }