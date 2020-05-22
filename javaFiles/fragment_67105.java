//in On click
MessagesFragment fragobj=new MessagesFragment();
 Bundle bundle=new Bundle()
bundle.putString("message", "From Activity");
fragobj.setArguments(mBundle);
switchFragment(R.id.container, fragobj); //replace container ID


public void switchFragment(int id, Fragment fragment) {
    if (context == null)
        return;

    //MainActivity is your activity where FriendsFragment is called
    if (context instanceof MainActivity) {
        MainActivity mainActivity = (MainActivity) context;
        mainActivity.loadFragment(id, fragment);
    }
}