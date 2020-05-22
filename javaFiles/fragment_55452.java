class ApiResponse {

    // other fields

    @JsonProperty("data")
    private Map<String, VehicleResponse> vehicles;

}