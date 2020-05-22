...
@Override
public View onCreateView(La...) {
...
    mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
...
    initList();
    isUserFavorite();
    initSelection();
    return view;
}

public void isUserFavorite() {
    mFavorites = new ArrayList<>();
    for (User user : mUsers) {
        if (user.isFavorite()) {
            mFavorites.add(user);
        }
    }    
}

private void initList() {
    mUser = mApiService.getUsers();    
}


public void initSelection() {
  mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        // assuming users is at tab index 0 and favorites is at tab Index 1
        if(tab.getPosition() == 1) {
            selectFavorites();
        } else {
            selectUsers();
        }
    }
    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }
    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }
  });
  // if you wish to select the users tab at 0 by default
  Objects.requireNonNull(mTabLayout.getTabAt(0)).select();
}

private void selectFavorites() {
    // whichever adapter you were using to show favorites
    MyUserRecyclerViewAdapter mFavAdapter = new MyUserRecyclerViewAdapter(mFavorites, context);
    mRecyclerView.setAdapter(mFavAdapter);
    mFavAdapter.notifyDataSetChanged();
}

private void selectUsers() {
    // whichever adapter you were using to show all users
    MyNeighbourRecyclerViewAdapter mUsersAdapter = new MyNeighbourRecyclerViewAdapter(mUsers, context);
    mRecyclerView.setAdapter(mUsersAdapter);
    mFavAdapter.notifyDataSetChanged();
}