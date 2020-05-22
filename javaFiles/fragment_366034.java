public static void main(String[] args) {

        BufferedReader myInput = new BufferedReader (new InputStreamReader (System.in));// Buffered Reader reads the number inputed 

        String key [] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String keyA [] = {"N","O","P","Q","R","S","T","U","V","W","X","Y","Z","A","B","C","D","E","F","G","H","I","J","K","L","M"};

        System.out.println("Enter a phrase: ");
        String phrase = "";

        try {
            phrase = myInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int length = phrase.length();
        int y = 0, i = 0, num = 0;

        while (y < length) { // This should be y < length. Otherwise, it would throw a StringIndexOutOfBoundsException.
            i=0; // Re-initialize
            String letter = Character.toString(phrase.charAt(y));
//            y++; // Unecessary incremental
            while(!(letter.equalsIgnoreCase(key[i]))){
                i++;
            }
            num = i;
            System.out.print(keyA[num]);
            y++;
        }

    }