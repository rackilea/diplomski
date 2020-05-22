public List<String> trimStrings(Listy<String> listToTrim) {
    List<String> trimmedList = new ArrayList<String>(listToTrim.size());
    for (String str : listToTrim) {
      trimmedList.add(str.trim());
    }
    return trimmedList;
}