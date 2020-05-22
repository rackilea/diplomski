@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (savedInstanceState != null) {
        // <restore state>
    }
    else {
        // <initialize stuff>

        // add main menu -- CORRECT!
        MainMenuFragment mainMenu = new MainMenuFragment();
        FragmentTransaction ft = this.getSupportFragmentManager().beginTransaction();
        ft.add(R.id.contents, mainMenu);
        ft.commit();
    }
}