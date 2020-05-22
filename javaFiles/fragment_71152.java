import retrofit2.Call;
import retrofit2.http.GET;

public interface ReceiptsLineInterface {

    String JSONURL = "http://[censored]/api/putaway/id/{receipts_line}/";

    @GET("WRONG ENDPOINT")
    Call<String> getString();
}