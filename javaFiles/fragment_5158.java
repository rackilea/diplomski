class Document {
    public String id;
    public int version;
    public Document(String id, int version) {
        this.id = id;
        this.version = version;
    }
    public String toString() {
        return "Document{"+id+version+ "}";
    }
}

public class MyClass {
    private static List<Document> docs = asList(
        new Document("A", 1),
        new Document("A", 2),
        new Document("B", 1),
        new Document("C", 1),
        new Document("C", 2)
    );

    public static void main(String args[]) {
        StreamEx<List<Document>> groups = StreamEx.of(docs).groupRuns((l, r) -> l.id.equals(r.id));
        for (List<Document> grp: groups.collect(toList())) {
            out.println(grp);
        }
    }
}