public class MS1SystemStatusResponse {
  // ...
  @SerializedName("WARNING_CONDITION_LIST")
  @JsonAdapter(EmptyStringAsNullTypeAdapter.class)
  WARNING_CONDITION_LIST warningConditionListMy;
  // ...
}