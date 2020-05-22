// Previous code to here

// Linked list of unique entries
LinkedList uniqueMatches = new LinkedList();

// Existing code
while ((line = ij.readLine()) != null) {
    line = line.replaceAll("\\(([^\\)]+)\\)", " " );
    line = line.replaceAll("[^\\w]", " ");
    line = line.replaceAll("\\bint\\b|\\breturn\\b|\\bmain\\b|\\bprintf\\b|\\bif\\b|\\belse\\b|\\bwhile\\b", " ");
    line = line.replaceAll(" \\d", "");
    line = line.replaceAll(" ", "\n");
    line = line.trim();

    Matcher m = p.matcher(line);

    while (m.find()) {
        // New code - get this match
        String thisMatch = m.group();
        // If we haven't seen this string before, add it to the list
        if(!uniqueMatches.contains(thisMatch))
            uniqueMatches.add(thisMatch);
    }
}

// Now see how many unique strings we have collected
count = uniqueMatches.size();