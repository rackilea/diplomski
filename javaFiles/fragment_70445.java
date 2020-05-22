final Set<Map.Entry<String, List<FeatureKey>>> entries = pFeatureGroupsFromPackage.entrySet();

for (Map.Entry<String, List<FeatureKey>> entry : entries) {
    String key = entry.getKey();
    List<FeatureKey> tmpList = entry.getValue();

    // do whatever
}