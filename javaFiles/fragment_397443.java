public static void main(String[] arg) {
        Scanner keyboard = new Scanner(System.in);
            System.out.print("Type a string: ");
            String word = keyboard.nextLine(); 
            System.out.printf ("New string: %s", removeVowels(word));
            System.out.print ("\nThank you for using the system");
        }

        public static String removeVowels (String word) {
            String str=word;
            str = str.replaceAll("[AEIOUaeiou]", "");           
                return word;
        }