int loops = Math.min(3, allMatches.size());
if (event.getMessage().getContent().startsWith("!!")) 
    loops = allMatches.size();

for (int i = 0; i < loops; i++) {
  event.getTextChannel().sendMessage((i + 1) + ".\\) " + allMatches.get(i).replace("\"", "").replace(",", "; ")
   .replace("[", " ").replace("]", "").replace("english_definitions:", "")).queue();
 }