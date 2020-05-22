public interface OnLoggedInChangedListener {
    public void onLoggedInChange(boolean loggedIn);
}

private OnLoggedInChangedListener loggedInListener; // This could also be a list of weak references

public void setOnLoggedInChangedListener(OnLoggedInChangedListener l) {
    loggedInListener = l;
}

public void setLoggedIn(Boolean loggedIn){
    this.loggedIn = loggedIn;
    if (loggedInListener != null) {
        loggedInListener.onLoggedInChange(loggedIn);
    }
}