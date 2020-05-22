String template = "Hey {how} are $=you";
StringBuilder populatedTemplate = new StringBuilder();
Map<String, String> map = new HashMap<>();
map.put("how", "HH");
map.put("you", "YY");
// Pattern allowing to extract only the words
Pattern pattern = Pattern.compile("\\w+");
Matcher matcher = pattern.matcher(template);
int fromIndex = 0;
while (matcher.find(fromIndex)) {
    // The start index of the current word
    int startIdx = matcher.start();
    if (fromIndex < startIdx) {
        // Add what we have between two words
        populatedTemplate.append(template, fromIndex, startIdx);
    }
    // The current word
    String word = matcher.group();
    // Replace the word by itself or what we have in the map
    populatedTemplate.append(map.getOrDefault(word, word));
    // Start the next find from the end index of the current word
    fromIndex = matcher.end();
}
if (fromIndex < template.length()) {
    // Add the remaining sub String
    populatedTemplate.append(template, fromIndex, template.length());
}
System.out.println(populatedTemplate);