// To check if any of them contains
boolean anyContains = list.stream().any(m -> m.contains("term"));
// get string which did not have value
list<String> nonUsedTerms = list.stream
                    .filter(m -> !m.contains(term))
                    .map(m -> m.get(term));