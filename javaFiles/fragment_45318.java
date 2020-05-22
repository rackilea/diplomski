final Pattern targetWordPattern =
    Pattern.compile("\\b" + Pattern.quote(targetWord) + "\\b",
                    Pattern.CASE_INSENSITIVE);

String line = "";
boolean wordFound = false;

while((line = bufRead.readLine()) != null) {
    if(targetWordPattern.matcher(line).find()) {
        wordFound = true;
        break;
    }
    else
        output = "Quote not found";
}