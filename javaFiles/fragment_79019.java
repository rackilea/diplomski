@Inject
GameName mGame;
@Inject
MenuScreen mMenu;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ((GameApplication) getApplication()).getGameComponent().inject(this);

    initialize(mGame);
}