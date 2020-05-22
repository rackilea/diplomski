static class PreRecordedCall {
    @SerializedName("IsOperationSuccessful")
    private Boolean isOperationSuccessful;

    @SerializedName("IsResult")
    private Boolean isResult;

    @SerializedName("StatusCode")
    private String statusCode;

    @SerializedName("Response")
    private List<Response> response;

    @SerializedName("Total")
    private int total;

    //general getters and setters
}