ArrayList anythingGoes = new ArrayList();
ArrayList<String> onlyStrings = anythingGoes; // Unchecked/unsafe op
anythingGoes.add(new Date());
for (String s : onlyStrings) { // Blows up
    // ...
}