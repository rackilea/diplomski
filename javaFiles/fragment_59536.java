List<String> values = new ArrayList<>();
values.add("Articles");
values.add("Vals");
values.add("Articles");
values.add("Toast");

String searchTerm = "Articles";

List<Integer> matchingIndices = new ArrayList<>();

for (int i = 0; i < values.size(); i++) {
    String candidate = values.get(i);
    if (candidate.indexOf(searchTerm) >= 0) {
        matchingIndices.add(i);
    }
}

int numberOfMatches = matchingIndices.size();

System.out.println("Values: " + values);
System.out.println("Indexes of the key '" + searchTerm + "': " + matchingIndices);
System.out.println("The key appears " + numberOfMatches + " times.");