//  StringBuilder with initial String
StringBuilder builder = new StringBuilder(WIKI_WIKIPEDIA); 
for (int i=1; i < stringTerm.length; i++) {
   builder.append(stringTerm[i]);
}
String searchTerm = builder.toString();