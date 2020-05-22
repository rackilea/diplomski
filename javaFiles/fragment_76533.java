@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    final String test = (String) getLastNonConfigurationInstance();
    if (!("textAlreadyShown").equals(test)) {
        //here : show your dialog
    }
}

@Override
public String onRetainNonConfigurationInstance() {
    return "textAlreadyShown";
}