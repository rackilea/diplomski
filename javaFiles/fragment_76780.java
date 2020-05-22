String keyword = "someword";
int numberOfLinesToDisplay = 2;

List<String> list = new ArrayList<>();

BufferedReader br = new BufferedReader(new FileReader(myFile));

int i = 0;

// Loop over each line
String line;
while ((line = br.readLine()) != null) {

    // Add the line to the list
    list.add(line);

    // Checking for the keyword...
    if (keyword.equals(line.trim())) {

        // Reverse the for loop to print "forwards"
        for (int j = numberOfLinesToDisplay; j >= 0; j--) {
            // Make sure there is something there
            if (i - j >= 0) {
                // Simply print it
                System.out.println(list.get(i - j));
            }
        }
    }

    i++;
}