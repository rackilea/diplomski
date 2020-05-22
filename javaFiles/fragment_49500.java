public class LoadJson<T> {

 Response<T> load(String responseElement, Type classType){

  Gson gson = new Gson();

    Response<T> response = gson.fromJson(responseElement, classType);

  return response;
  }
}