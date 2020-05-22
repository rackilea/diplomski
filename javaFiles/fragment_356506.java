public static void main(String[] args) {

        String first_string = "THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG";
        String second_string = "UIFARVJDLACSPXOAGPYAKVNQTAPWFSAUIFAMB ZAEPH";
        String third_string = "XFABSFAWFSZACBEAQFPQMFAEPJOHAWFSZACBEAUIJOHTAIBAIB";

        char[] first = first_string.toCharArray();
        char[] second = second_string.toCharArray();
        char[] third = third_string.toCharArray();
        char[] compare_a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'}; //length = 26
        char[] compare_b = new char[26]; //length = 26

        for (int x = 0; x < first.length; x++) {// going through first array
            char first_letter = first[x]; // gets letter from first string

            for (int z = 0; z < 26; z++) { // looks through alphabet for the position of the letter
                if (first_letter == compare_a[z]) { // if the letter is found at a certain position
                    // System.out.println(first_letter + " = " + compare_a[z] + " " + compare_b[z]  + " " +  second[x]);
                    compare_b[z] = second[z]; // insert into the same position on the second array
                }
            }
        }

        for (int t = 0; t < 26; t++) {

            char m = compare_b[t];
            System.out.print(m); //Printing out array of new letters
        }
    }