UserLocalStore userLocalStore = new UserLocalStore();
if(userLocalStore.getLoggedInUser()){
    //Logged in 
}else{
    Intent intent = new Intent(getActivity(), loginscreen.class);
    startActivityForResult(intent, 1);
}