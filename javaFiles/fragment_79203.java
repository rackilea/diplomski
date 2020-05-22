private void onFriendClick(FriendHolder holder, int position) {
    Intent intent = new Intent(context, ProfileActivity.class);
    intent.putExtra(Consts.KEY_USER_JSON,  friendList.get(position));
    Log.e("onFriendClick", String.valueOf(friendList.get(position).getName()));
    context.startActivity(intent);
}

private void setupProfile() {
    if (getIntent().getSerializableExtra(Consts.KEY_USER_JSON) != null) {
        profile = (ProfileDTO) getIntent().getSerializableExtra(Consts.KEY_USER_JSON); 
        Log.e("onFriendClick", String.valueOf(profile.getName()));//NPE this
    } else {
        profile = user.getProfile();
    }
}