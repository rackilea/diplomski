Scanner sc = new Scanner("  jack   for { 123 for{}} rose for {}");
sc.useDelimiter("");
List<String> resultingParts = new ArrayList<>();
int currentNestingDepth=0;
StringBuilder currentPart= new StringBuilder();
while (sc.hasNext()) {
    char c = sc.next().charAt(0);
    if (c == '{') { currentNestingDepth++; }
    else if (c == '}') {
        currentNestingDepth--; //!\\ might fail with unbalanced parens, test > 0 if needed

        if (currentNestingDepth == 0) { //we've reached the end of a part
            currentPart.append(c);
            resultingParts.add(currentPart.toString());
            currentPart = new StringBuilder();
            continue; // to avoid adding the current character yet again
        }
    }
   currentPart.append(c);
}
if (currentPart.length() > 0) { resultingParts.add(currentPart.toString()); }