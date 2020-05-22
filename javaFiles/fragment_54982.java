public String joinTheStrings(String[] theStrings) {
     StringBuilder joinedString = new StringBuilder();
     for (String singleString : theStrings)
          joinedString.append(singleString);
     return joinedString.toString();
}