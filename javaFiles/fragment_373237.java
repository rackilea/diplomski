Scanner keywords = new Scanner(new File("keywords.txt"));

    ArrayList<String> stack = new ArrayList<String>();
    ArrayList<String> csvLines = new ArrayList<String>();

    // stores the number of elements of the last line processed
    int lastSize = -1;

    while (keywords.hasNext()) {
        String line = keywords.nextLine();

        int tabs = 0;
        // Count tabs of current line
        while (line.length() > tabs // to avoid IndexOutOfBoundsException in charAt()
                && line.charAt(tabs) == '\t') {
            tabs++;
        }

        line = line.substring(tabs); // delete the starting tabs

        if (tabs <= lastSize) {
            // if the current line has the same number of elements than the previous line, 
            // then we can save the previous processed line as CSV 
            String csvLine = "";
            for (String element : stack) {
                if (csvLine.length() > 0) {
                    csvLine += ", ";
                }
                csvLine += element;
            }
            csvLines.add(csvLine);
        }

        // if the current line has less tabs than the previous, then cut the stack 
        for (int i = stack.size() - 1; i >= tabs; i--) {
            stack.remove(i);
        }

        // if the current line has more tabs than the previous, then add the new element to the stack
        if (tabs >= stack.size()) {
            stack.add(line);
        }

        // save the number of tabs of the current line
        lastSize = tabs;
    }
    keywords.close();

    // we have to save the last line processed
    if (lastSize >= 0) {
        // save line
        String csvLine = "";
        for (String element : stack) {
            if (csvLine.length() > 0) {
                csvLine += ", ";
            }
            csvLine += element;
        }
        csvLines.add(csvLine);
    }

    // print out CSV
    for (String string : csvLines) {
        System.out.println(string);
    }