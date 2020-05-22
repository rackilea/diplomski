private String deleteNonUniqueWords(String str) {    
    Set<String> result = new LinkedHashSet<>(Arrays.asList(str.split("\\s+")));
    StringBuilder sb = new StringBuilder();
    for (String s : result) {
        sb.append(s);
        sb.append(" ");
    }
    return sb.toString();
}