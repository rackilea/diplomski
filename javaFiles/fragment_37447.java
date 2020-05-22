public class TransactionDTO {
    private @JsonProperty("Data") Data[] data;
    private @JsonProperty("Links") Links links;
    private @JsonProperty("Meta") Meta meta;
    public Data[] getData () {  return data; }
    public void setData (Data[] data) { this.data = data; }
    public Links getLinks () { return links; }
    public void setLinks (Links links) { this.links = links; }
    public Meta getMeta () { return meta; }
    public void setMeta (Meta meta) { this.meta = meta; }
}