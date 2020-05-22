class TextExtractorBean{
...
  getExtractedText(){
    Pattern pattern = Pattern.compile("<([a-z])+>");
    Matcher matcher = pattern.matcher(text);

    int firstIdxAfterOpeningTags = 0;
    while(matcher.find()){
        firstIdxAfterOpeningTags = matcher.end();
    }

    pattern = Pattern.compile("</([a-z])+>");
    matcher = pattern.matcher(text);

    int firstIdxBeforeClosingTags = text.length();
    if(matcher.find()){
        firstIdxBeforeClosingTags = matcher.start();
    }

    String extractedText = text.substring(firstIdxAfterOpeningTags,
            firstIdxBeforeClosingTags);
    String shortenedText = extractedText.length() > 0 ? extractedText
            .substring(0,100) : extractedText;
    return shortenedText;
  }
...
}