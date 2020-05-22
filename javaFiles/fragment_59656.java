public class Result {

@SerializedName("barcodes")
@Expose
private List<List<String>> barcodes = new ArrayList<List<String>>();

/**
* 
* @return
* The barcodes
*/
public List<List<String>> getBarcodes() {
return barcodes;
}

/**
* 
* @param barcodes
* The barcodes
*/
public void setBarcodes(List<List<String>> barcodes) {
this.barcodes = barcodes;
}

}