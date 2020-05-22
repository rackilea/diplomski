public interface MatchAction {
  public void doTheThing();
}

Map<String, MatchAction> actionMap = new HashMap<String,MatchAction>();
// Fill this bad boy up
actionMap.put("one", new MatchAction() { public void doTheThing() { /* do stuff */ } });
// Etc for each action (you can reuse instances here if some actions are the same)
// Then, we modify the check above to be:
for (String match : matches) {
  if (match.equals(inputs.peek())) {
    String input = inputs.pop();
    MatchAction action = actionMap.get(input);
    if (action != null) action.doTheThing();
  }
}