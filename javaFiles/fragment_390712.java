String[] cancelWords = {"cancel", "nevermind", "scratch that"};
boolean found = false;
for(String cancelWord : cancelWords) {
  found = value.equals(cancelWord);
  if (found) break;
}