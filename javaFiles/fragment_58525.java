private void startLoginActivity(LogoutTypeEnum logoutType) {
    Intent intent = new Intent(this, LoginActivity.class);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    intent.putExtra(AppConfig.Args.DATA_ITEM_OTHER, logoutType);
    startActivity(intent);
}

public void onEvent(LogoutEvent event) {
    if (this.isActivityPaused) {
        this.shouldLogoutOnResume = true;
        return;
    }

    this.startLoginActivity(event.getLogoutType());
}

public void activityPaused() {
    this.isActivityPaused = true;
}

public void activityResumed() {
    this.isActivityPaused = false;

    if (this.shouldLogoutOnResume) {
        this.startLoginActivity(LogoutTypeEnum.SESSION_EXPIRED);
        this.shouldLogoutOnResume = false;
    }

}