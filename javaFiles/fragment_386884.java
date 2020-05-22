public class Result {
    private int totalSize;
    private boolean done;
    private List<Record> records;
}

public class Record {
    private transient Map<String, String> attributes;
    private int AccountId;
    private int Id;
    private int ProposalID;
}