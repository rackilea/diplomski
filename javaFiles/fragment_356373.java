public class ShipmentResponse {

        @JsonProperty("IsValid")
        private boolean isValid;
        @JsonProperty("ModelErrors")
        private ModelErrors modelErrors;
        @JsonProperty("ValidationErrors")
        private List<Integer> validationErrors = null;
}