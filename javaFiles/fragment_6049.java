Multimap<String, String> toMultimap(MultiLabelDataset<String, String> dataset) {
    Multimap<String, String> result = HashMultimap.create();
    for (Item key : ((LabeledLDADataset) dataset).items()) {
        result.putAll(key.toString(), dataset.getLabels(key));
    }
    return result;
}