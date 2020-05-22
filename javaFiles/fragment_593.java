/**
 * Show PIN/Password confirmation dialog.
 */
void ShowConfirmLockPINActivity() {
    CustomLog.i(TAG, "Show Confirm Lock PIN Activity");
    Intent intent = new Intent(Intent.ACTION_RUN);
    intent.setComponent(new ComponentName("com.android.settings",
        "com.android.settings.ConfirmLockPassword"));
    startActivityForResult(intent, mRequestCode);
} /* ShowConfirmLockPINActivity() */

/**
 * Show set PIN/Password dialog.
 */
void ShowSetLockPINActivity() {
    CustomLog.i(TAG, "Show Set Lock PIN Activity");
    Intent intent = new Intent(Intent.ACTION_RUN);
    intent.setComponent(new ComponentName("com.android.settings",
        "com.android.settings.ChooseLockPassword"));
    startActivityForResult(intent, mRequestCode);
} /* ShowSetLockPINActivity() */

/**
 * Show Pattern Confirmation dialog.
 */
void ShowSetLockPatternActivity() {
    CustomLog.i(TAG, "Show Set Lock Pattern Activity");
    Intent intent = new Intent(Intent.ACTION_RUN);
    intent.setComponent(new ComponentName("com.android.settings",
        "com.android.settings.ConfirmLockPattern"));
    startActivityForResult(intent, mRequestCode);
} /* ShowSetLockPatternActivity() */