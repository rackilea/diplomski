statements.add("INSERT");
for (int i = 1; i < lines.size(); i++) {
    // ...
    statements.add(String.format(template, tableN, cols.toString(), vals.toString()));
}
statements.add("FROM DUAL;\nCOMMIT;");