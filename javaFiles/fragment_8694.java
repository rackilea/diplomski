public class FbActivity extends FragmentActivity {

private static final String PERMISSION = "publish_actions";


private final String PENDING_ACTION_BUNDLE_KEY = "com.facebook.samples.hellofacebook:PendingAction";

private LoginButton loginButton;
private ProfilePictureView profilePictureView;
private TextView greeting;
private PendingAction pendingAction = PendingAction.NONE;
private ViewGroup controlsContainer;
private GraphUser user;
private GraphPlace place;
private List<GraphUser> tags;
private boolean canPresentShareDialog;


private UiLifecycleHelper uiHelper;

private Session.StatusCallback callback = new Session.StatusCallback() {
    @Override
    public void call(Session session, SessionState state,
            Exception exception) {
        onSessionStateChange(session, state, exception);
    }
};

private FacebookDialog.Callback dialogCallback = new FacebookDialog.Callback() {
    @Override
    public void onError(FacebookDialog.PendingCall pendingCall,
            Exception error, Bundle data) {
        Log.d("HelloFacebook", String.format("Error: %s", error.toString()));
    }

    @Override
    public void onComplete(FacebookDialog.PendingCall pendingCall,
            Bundle data) {
        Log.d("HelloFacebook", "Success!");
    }
};

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    uiHelper = new UiLifecycleHelper(this, callback);
    uiHelper.onCreate(savedInstanceState);
    if (savedInstanceState != null) {
        String name = savedInstanceState
                .getString(PENDING_ACTION_BUNDLE_KEY);
        pendingAction = PendingAction.valueOf(name);
    }

    setContentView(R.layout.activity_fb);


    loginButton = (LoginButton) findViewById(R.id.login_button);
    loginButton
            .setUserInfoChangedCallback(new LoginButton.UserInfoChangedCallback() {
                @Override
                public void onUserInfoFetched(GraphUser user) {
                    FbActivity.this.user = user;

                    onClickPostPhoto();

                    updateUI();
                    // It's possible that we were waiting for this.user to
                    // be populated in order to post a
                    // status update.
                    handlePendingAction();
                }
            });

    profilePictureView = (ProfilePictureView) findViewById(R.id.profilePicture);
    greeting = (TextView) findViewById(R.id.greeting);

    controlsContainer = (ViewGroup) findViewById(R.id.main_ui_container);

    final FragmentManager fm = getSupportFragmentManager();
    Fragment fragment = fm.findFragmentById(R.id.fragment_container);
    if (fragment != null) {
        // If we're being re-created and have a fragment, we need to a) hide
        // the main UI controls and
        // b) hook up its listeners again.
        controlsContainer.setVisibility(View.GONE);

    }

    // Listen for changes in the back stack so we know if a fragment got
    // popped off because the user
    // clicked the back button.
    fm.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
        @Override
        public void onBackStackChanged() {
            if (fm.getBackStackEntryCount() == 0) {
                // We need to re-show our UI.
                controlsContainer.setVisibility(View.VISIBLE);
            }
        }
    });

    canPresentShareDialog = FacebookDialog.canPresentShareDialog(this,
            FacebookDialog.ShareDialogFeature.SHARE_DIALOG);
}

@Override
protected void onResume() {
    super.onResume();
    uiHelper.onResume();

    // Call the 'activateApp' method to log an app event for use in
    // analytics and advertising reporting. Do so in
    // the onResume methods of the primary Activities that an app may be
    // launched into.
    AppEventsLogger.activateApp(this);

    updateUI();
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    uiHelper.onSaveInstanceState(outState);

    outState.putString(PENDING_ACTION_BUNDLE_KEY, pendingAction.name());
}

@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    uiHelper.onActivityResult(requestCode, resultCode, data, dialogCallback);
}

@Override
public void onPause() {
    super.onPause();
    uiHelper.onPause();
}

@Override
public void onDestroy() {
    super.onDestroy();
    uiHelper.onDestroy();
}

private void onSessionStateChange(Session session, SessionState state,
        Exception exception) {
    if (pendingAction != PendingAction.NONE
            && (exception instanceof FacebookOperationCanceledException || exception instanceof FacebookAuthorizationException)) {
        new AlertDialog.Builder(FbActivity.this)
                .setTitle(R.string.cancelled)
                .setMessage(R.string.permission_not_granted)
                .setPositiveButton(R.string.ok, null).show();
        pendingAction = PendingAction.NONE;
    } else if (state == SessionState.OPENED_TOKEN_UPDATED) {
        handlePendingAction();
    }
    updateUI();
}

private void updateUI() {
    Session session = Session.getActiveSession();
    boolean enableButtons = (session != null && session.isOpened());

    if (enableButtons && user != null) {
        profilePictureView.setProfileId(user.getId());
        greeting.setText(user.getFirstName());

    } else {
        profilePictureView.setProfileId(null);
        greeting.setText(null);
    }
}

@SuppressWarnings("incomplete-switch")
private void handlePendingAction() {
    PendingAction previouslyPendingAction = pendingAction;
    // These actions may re-set pendingAction if they are still pending, but
    // we assume they
    // will succeed.
    pendingAction = PendingAction.NONE;
    // pendingAction = PendingAction.POST_PHOTO;

}

private interface GraphObjectWithId extends GraphObject {
    String getId();
}
}