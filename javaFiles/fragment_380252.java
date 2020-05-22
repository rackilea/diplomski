@ApiModel(description="the paginated history of the specification attributes values")
public class SpecificationHistoryResponse  {

  @ApiModelProperty(example = "null", value = "the array of historic values is named with the specification attributes key")
  @JsonAnySetter
  private Map<String, List<SpecificationResponse>>  key = new HashMap<>();
  @ApiModelProperty(example = "null", value = "")
  private Pagination pagination = null;

 /**
   * the array of historic values is named with the specification attributes key
   * @return key
  **/
  public Map<String, List<SpecificationResponse>>  getKey() {
    return key;
  }

  public void setKey(Map<String, List<SpecificationResponse>> key) {
    this.key = key;
  }

  public SpecificationHistoryResponse key(Map<String, List<SpecificationResponse>>  key) {
    this.key = key;
    return this;
  }
 /* ... */
}