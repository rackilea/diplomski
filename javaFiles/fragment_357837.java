public class LoginActivity extends FirebaseUserNet implements ContactPermissionRequester {

    @Override
    public boolean mayRequestContacts() {
        ...
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, 
        @NonNull int[] grantResults) {
            ...
        }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        inputEmail = (AutoCompleteTextView) findViewById(R.id.email);
        AutoCompleteTextViewLoader autoloader = new AutoCompleteTextViewLoader(this, 
            inputEmail, getSupportLoaderManager());
        autoloader.populate();

    }
}