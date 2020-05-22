public static void main( String[] args ){
        String sWord= new String();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a Word");
        sWord = input.nextLine();

        int[] cArr = new int[1024];

        for(char c : sWord.toCharArray()) {
            if((int) c <= cArr.length) {
                cArr[(int) c]++;
            }
        }

        for(int x = 0; x < cArr.length; x++) {
            if(cArr[x] > 0) {
                System.out.print((char) x + ":" + cArr[x]);
            }
        }
    }