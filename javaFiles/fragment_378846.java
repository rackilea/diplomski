import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CoinMarketClient {
@GET("listings")
Single<CoinMarketListingsReponse> getListings();

@GET("ticker/{id}")
Single<CoinMarketCurrencyResponse> getCurrency(@Path("id") int id);

@GET("ticker/{id}/?convert={fiat}")
Single<CoinMarketCurrencyResponse> getCurrency(@Path("id") int id, 
@Path("fiat") String fiatCode);
}