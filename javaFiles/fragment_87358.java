protected void onCreate(Bundle savedInstanceState) {
    //...
    //standard onCreate() stuff that creates set configs toolbar, mDrawerLayout & mDrawerToggle

    //Use the appropriate adapter that extends MenuBaseAdapter:
    DrawerListenerAdapter mDrawerListenerAdapter = new DrawerListenerAdapter(mDrawerToggle, R.id.drawerList);
    mDrawerListenerAdapter.setDrawerLayout(mDrawerLayout);

    //Add desired transition to the adapter, MenuItemTransitionBuilder is used to build the transition:
    //Creates a shared configuration that: applies alpha, the transition effect is applied in a cascading manner (v.s. simultaneously), MenuItems will resets to enabled when transiting, and invalidates menu on transition completion 
    MenuItemTransitionBuilder builder = MenuItemTransitionBuilder.transit(toolbar).alpha(1f, 0.5f).scale(1f, 0f).cascade(0.3f).visibleOnStartAnimation(true).invalidateOptionOnStopTransition(this, true);
    MenuItemTransition mShrinkClose = builder.translationX(0, 30).build();
    MenuItemTransition mShrinkOpen = builder.reverse().translationX(0, 30).build();
    mDrawerListenerAdapter.setupOptions(this, new MenuOptionConfiguration(mShrinkOpen, R.menu.drawer), new MenuOptionConfiguration(mShrinkClose, R.menu.main));
  }

  //Let the adapter manage the creation of options menu:
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      mDrawerListenerAdapter.onCreateOptionsMenu(this, menu);

      return super.onCreateOptionsMenu(menu);
  }