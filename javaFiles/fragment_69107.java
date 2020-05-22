String data = "...";

StringBuilder finalData = new StringBuilder(data.length());
for(int i = 0; i < data.length() - 1; i++) {
    char replacement = getReplacement(data.charAt(i));
    finalData.append(replacement);
}
finalData.append(data.charAt(data.length() - 1));

String result = finalData.toString();