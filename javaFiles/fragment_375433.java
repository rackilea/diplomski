String values = "JAMES SMITH, NAVIN HEMANT SIGNH, LALA UTRIZER";


if (values != null && !values.isEmpty()) {
    final StringBuilder fixedCaseBuilder = new StringBuilder(values.length()+1);

    for (final String word : values.split(" ")) {
        if (!word.isEmpty()) {
            fixedCaseBuilder.append(Character.toUpperCase(word.charAt(0)));
            fixedCaseBuilder.append(word.substring(1, word.length()).toLowerCase());
        }
        fixedCaseBuilder.append(' ');
    }

    fixedCaseBuilder.setLength(fixedCaseBuilder.length()-1);
    final String result = fixedCaseBuilder.toString();
}