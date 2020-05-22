public static void main(String args[]) {

            Scanner keyboard = new Scanner(System.in);

            String arrInput[], input;
            String arrText[] = null, text, text_word, text_remain;
            int i;


            while (true) {
                // Type
                System.out.println("type string: ");
                input = keyboard.nextLine();
                input = input.toLowerCase();

                // If user type quit, terminate the program
                if (input.compareTo("quit") == 0)
                    break;

                arrInput = input.split(""); // by breaking the input should be kept
                                            // in arrInput (the input array)

                // Send letters to the front to the back of the input (stored
                // separately in the text)
                text_word = input.substring(0, 1); // the beginning of the input
                                                    // text to Back
                text_remain = input.substring(1, input.length()); // from the second
                                                                    // to the last
                                                                    // character of
                                                                    // the input
                text = text_remain.concat(text_word); // merges into the text
                System.out.println(text);
                // break up the text should be kept in arrText (the text array)


                // input (from the back) and text (from the front) to check for
                // equality
                // Correct, check = true, incorrect, check = false
                String original = text;
                String reverse = new String();
                int length = original.length();

                for (i = length - 1; i >= 0; i--)
                    reverse = reverse + original.charAt(i);

                if (input.equals(reverse))
                    System.out.println("equal");
                else 
                    System.out.println("Not equal");

            }
        }
    }