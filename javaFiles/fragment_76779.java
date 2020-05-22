final String input = "line1\nline2\nsomeword\nline4\nline5";

int numberOfLinesToDisplay = 2;
String keyword = "someword";

// Split on the newline character
String[] lines = input.split("\n");

// Loop over each line
for (int i = 0; i < lines.length; i++) {

    String line = lines[i];

    // Checking for the keyword...
    if (keyword.equals(line)) {

        // Reverse the for loop to print "forwards"
        for (int j = numberOfLinesToDisplay; j >= 0; j--) {
            // Make sure there is something there
            if (i - j >= 0) {
                // Simply print it
                System.out.println(lines[i - j]);
            }
        }
    }

}