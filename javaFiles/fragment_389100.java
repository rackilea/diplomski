//if its a list
//Type dataType = new TypeToken<ResponseTemplate<List<MyModelClass>>>() {}.getType();

//if its a single object
Type dataType = new TypeToken<ResponseTemplate<MyModelClass>>() {}.getType();
ResponseTemplate response = new Gson().fromJson(gson.toJson(apiService.getMyObject(), dataType), dataType);

MyModelClass myModelClass = response.getData();