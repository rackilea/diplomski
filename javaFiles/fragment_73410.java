public interface UserService {

String ENDPOINT = "http://localhost:3000/";

@GET("users")
Call<APIResponse> getUsers();

}