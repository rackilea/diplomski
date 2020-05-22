public class ApiResponse<T> {

   @SerializedName("body")
   private ApiResponseBody<T> body;

   public ApiResponse() {
   }

   public ApiResponse(ApiData<T> body) { 
       this.body = body;
   }
}

public class ApiResponseBody<T> {

   @SerializedName("data")
   private T data;

   @SerializedName("errors")
   private Map<String, List<String>> errors;

   public ApiResponseBody() {
   }

   public ApiResponseBody(T data, Map<String, List<String>> errors) {
       this.data = data;
       this.errors = errors;
   }
}