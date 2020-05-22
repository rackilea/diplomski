// iterate over the mapkey and return the body text replace
for (final String key : replaceKeyMap.keySet()) {
    String replacementKey = "(?i)" + key;
    String replacementValue = replaceKeyMap.get(key);
    if (replacementValue == null) {
        replacementValue = "";
    }
    *replacementValue = replacementValue.replace("\\",     
        "\\\\").replace("$","\\$"); // sanitizes '$' and '\'* //only added this
    bodyText = bodyText.replaceAll(replacementKey, replacementValue);
}

return bodyText;