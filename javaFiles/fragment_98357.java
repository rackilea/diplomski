@Override
public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.content_main, container, false);

    login = (LoginButton) view.findViewById(R.id.login_button);
    login.setReadPermissions("user_friends");

    // Callback registration
    login.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
        @Override
        public void onSuccess(LoginResult loginResult) {
            // App code
        }

        @Override
        public void onCancel() {
            // App code
        }

        @Override
        public void onError(FacebookException exception) {
            // App code
        }
    });
    /**
     *return view 
     */
    return view;
}