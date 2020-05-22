public class Result {

@SerializedName("data") @Expose private List<Datum> data = null; @SerializedName("nextKey") @Expose private Integer nextKey;

public List<Datum> getData() { return data; }

public void setData(List<Datum> data) { this.data = data; }

public Integer getNextKey() { return nextKey; }

public void setNextKey(Integer nextKey) { this.nextKey = nextKey; }

}