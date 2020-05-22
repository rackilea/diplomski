Map<Date, String> auditMap = new TreeMap<Date, String>();
Map<String, AggregatedAction> aggregatedActions = new HashMap<>();

// Traverse each action once.
for (Map.Entry<Date, String> e : auditMap.entrySet()) {
  Date date = e.getKey();
  String action = e.getValue();

  // If the number of types of actions is small, the lookup in the 
  // aggregatedActions map can be estimated to be O(1).
  AggregatedAction aggregated = aggregatedActions.get(action);
  if (aggregated == null) {
    aggregated = new AggregatedAction(date, action);
    aggregatedActions.put(action, aggregated);

  } else {
    aggregated.append(date);
  }
}

// If you want a copy of your original map,
// otherwise you could just update it in place.
Map<Date, String> auditMap2 = new LinkedHashMap<Date, String>(auditMap);

// O(b) where b is the number of types of actions.
for (AggregatedAction action : aggregatedActions.values()) {
  auditMap2.put(action.firstOccurence, action.concatenatedAction.toString());
}