private String replace(String originalText) {
    String replacedText = originalText.replaceAll(
            "\\b(he(?!/)|(?<!/)she)\\b", "he/she");
    replacedText = replacedText.replaceAll("\\b(He(?!/)|(?<!/)She)\\b",
            "He/She");
    replacedText = replacedText.replaceAll("\\b(his(?!/)|(?<!/)her)\\b",
            "his/her");
    replacedText = replacedText.replaceAll("\\b(His(?!/)|(?<!/)Her)\\b",
            "His/Her");
    replacedText = replacedText.replaceAll("\\bhim(?!/)\\b", "him/her");
    replacedText = replacedText.replaceAll("\\bHim(?!/)\\b", "Him/Her");
    return replacedText;
}