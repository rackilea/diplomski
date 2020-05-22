class Register extends Activity {

    private String URL;

    // ...

    protected void onCreate(Bundle savedInstanceState) {
        // ...
        URL = new PropertiesHandler(Register.this).getUrl() + "url.php";
        // ...
    }
}