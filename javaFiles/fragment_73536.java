String input = "adklsfjb$${xxx}dklsjfnsdklj${yyy}";

Pattern p = Pattern.compile("(\\$)?\\$\\{([^}]+)}");
for (Matcher m = p.matcher(input); m.find(); ) {
    if (m.start(1) == -1) {
        System.out.println("Found Type I match for variable '" + m.group(2) + "'" +
                           " at index " + m.start() + "-" + m.end());
    } else {
        System.out.println("Found Type II match for variable '" + m.group(2) + "'" +
                           " at index " + m.start() + "-" + m.end());
    }
}