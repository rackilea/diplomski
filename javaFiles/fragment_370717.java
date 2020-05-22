@Override
protected void onCreate(Bundle savedInstanceState) {

    ....

    if (SharedPrefManager.getInstance(this).isLoggedIn()) {
        CautaProbleme();
    }
}