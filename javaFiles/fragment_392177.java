public TweetCluster() {
}

public TweetCluster(Cluster c) {
    labels.add(c.getLabel());
    for (Document doc : c.getDocuments()) {
        docs.add(doc.getTitle());
    }
}

public List<String> getLabels() {
    return labels;
}

public void setLabels(List<String> labels) {
    this.labels = labels;
}

public List<String> getDocs() {
    return docs;
}

public void setDocs(List<String> docs) {
    this.docs = docs;
}

@Override
public String toString() {
    return String.format("[TweetCluster - labels: %s, docs:%s]", labels, docs);
}