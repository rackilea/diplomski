String template = "Hey {how} are $=you id=minScaleBox-${questionNumber}";
...
map.put("${questionNumber}", "foo");
StringBuilder regex = new StringBuilder();
boolean first = true;
for (String word : map.keySet()) {
    if (first) {
        first = false;
    } else {
        regex.append('|');
    }
    regex.append(Pattern.quote(word));
}
Pattern pattern = Pattern.compile(regex.toString());
...