Your api call.enqueue(new Callback<ActionWrapperObject>() {
                    @Override
                    public void onResponse(Call<ActionWrapperObject> call, Response<ActionWrapperObject> response) {
                        ActionWrapperObject actionWrapperObj= response.body();
                        if (actionWrapperObj!= null) {
                          ArrayList<ActionModel> actionModelList= actionWrapperObj.getActions();
//Here you got the list of actions. Do what ever you want with them. You can 
// differentiate each action on its type.
                                                    }
                    }