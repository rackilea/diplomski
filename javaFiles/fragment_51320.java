// you could use any of the words below to test your method:
    // banana, sneeze, radar, roof, kayak, mine, racer, racecar, refer, james, joyce

    List<String> someWords = new ArrayList<>(); // Stores words read from user input
    int count = 0;        // keeps track of Palindrome words only (define algorithm to count # of palindrome words
    int total = 0;        // Counts the total number of lines read from the given text file

    System.out.println(" Enter some words separated by white space");    // Ask for user input

    Scanner keyboard = new Scanner(System.in);

    // hint 1: Using keybord.next() will only return what comes before a space.
    // hint 2: Using keybord.nextLine() automaticatlly reads the enire current line.
    // store each word in a string variable and then do your operations

    for (String word : keyboard.nextLine().split(" ")) {
        int length = word.length();

        for (int i = 0; i < (length / 2); i++) {
            //debug: System.out.println("first word "+temp.charAt(i)+"  second word "+temp.charAt(Len-1-i));
            if (word.charAt(i) == word.charAt(length - 1 - i)) count++;
        }
        someWords.add(word);
        System.out.println("There are " + someWords.size() + " words in " + someWords);   // test
    }

    System.out.println("There are " + count + " palindromes out of " + total + " words.");

    keyboard.close();

    // x is a variable for count and y is variable total
    // #2. print “There are x palindromes out of y words”
    System.out.println("There are " + count + " palindromes out of " + total + " words.");
}