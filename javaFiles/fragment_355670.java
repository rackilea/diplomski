if (event.getMessage().getContent().startsWith("!!")) {
 for (int i = 0; i < allMatches.size(); i++) {
  event.getTextChannel().sendMessage((i + 1) + ".\\) " + allMatches.get(i).replace("\"", "").replace(",", "; ")
   .replace("[", " ").replace("]", "").replace("english_definitions:", "")).queue();
 }

} else {
 for (int i = 0; i < Math.min(3, allMatches.size()); i++) {
  event.getTextChannel().sendMessage((i + 1) + ".\\) " + allMatches.get(i).replace("\"", "").replace(",", "; ")
   .replace("[", " ").replace("]", "").replace("english_definitions:", "")).queue();
 }
}