public List<MyUser> getList(String stringJson){
  List<MyUser> myUser = null;
  Gson gson = new Gson();
  Type type = new TypeToken<List<MyUser>>() {}.getType();
  myUser = gson.fromJson(stringJson, type);
  return myUser;
}