public interface GetDataService {

@FormUrlEncoded
@POST("pocketdeal/togetallfavorites")
Call<Favourite> getFavorite(@Field("lat") Long lat, @Field("long") Long lng, @Field("android_id") String androidId, @Field("timezone") String timezone);

}