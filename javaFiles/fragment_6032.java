// init result set with keys from treemapOne
Set<String> remainingKeys = new HashSet<>(treemapOne.keySet());
// remove keys in treemapTwo
remainingKeys.removeAll(treemapTwo.keySet());
// remove values in treemapTwo
for (List<String> values : treemapTwo.valueSet()) {
    remainingKeys.removeAll(values);
}