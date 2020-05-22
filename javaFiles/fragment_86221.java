@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // add main menu -- WRONG!
    MainMenuFragment mainMenu = new MainMenuFragment();
    FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
    ft.add(R.id.contents, mainMenu);
    ft.commit();

    if (savedInstanceState != null) {
        // <restore state>
    }
    else {
        // <initialize stuff>
    }
}