private void saveData() {

SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);
SharedPreferences.Editor editor = sharedPreferences.edit();
Gson gson = new Gson();

//Fetch List
String json = sharedPreferences.getString("adapterss",null);
Type type = new TypeToken<ArrayList<Adapterr>>(){}.getType();
List<type> list = gson.fromJson(json,type);

//If already exists append to that list
if(list != null && list.size() > 0){
    for (int i = 0; i < newListToBeAppended.size(); i++) {
        list.add(newListToBeAppended.get(i));
    }
} else{
    //If not exists add the list which is fresh
    list = newListToBeAppended;
}

String listJSON = gson.toJson(list);//Assuming gonderilenFallar is your list
editor.putString("adapterss", listJSON);
editor.apply();
}