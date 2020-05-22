@Table(keyspace = "ks", name = "logs")
public Log() {
    @PartitionKey(0)
    private String source;

    @PartitionKey(1)
    private long date;

    @ClusteringColumn
    private long timestamp;

    private String message;
}