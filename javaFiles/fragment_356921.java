String input = ... // Your input here

// Convert the input into a set of character
final Set<Character> inputSet = new HashSet<>();
for (int i = 0; i < input.length(); i++) {
    inputSet.add(input.charAt(i));
}

// Use the method to compute the power set
Set<Set<Character>> powerSet = powerSet(inputSet);

// Output all elements
for (Set<Character> element : powerSet) {
    // Combine the character in the set to a String
    StringBuilder sb = new StringBuilder();
    for (Character c : element) {
        sb.append(c);
    }

    // Here is a final element ready for collection or a print
    String outputElement = sb.toString();
    // The method already prints the results by itself, you can modify it easily such that it returns a Set<String> or similar
    permutation(outputElement);
}