String str = "foo";

List<String> errors = new ArrayList<>();

if (str.length() < 5) {
    errors.add("At least 5 characters."); // exception 1
}

if (!str.matches(".*[0-9]+.*")) {
    errors.add("At least 1 digit."); // exception 2
}

// Check for more stuff

if (!errors.isEmpty()) {
    throw new Exception("There are problem(s) found:\n" + String.join("\n", errors));
}