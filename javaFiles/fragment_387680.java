/**
 * This is called for activities that set launchMode to "singleTop" in
 * their package, or if a client used the {@link Intent#FLAG_ACTIVITY_SINGLE_TOP}
 * flag when calling {@link #startActivity}.  In either case, when the
 * activity is re-launched while at the top of the activity stack instead
 * of a new instance of the activity being started, onNewIntent() will be
 * called on the existing instance with the Intent that was used to
 * re-launch it.
 *
 * <p>An activity will always be paused before receiving a new intent, so
 * you can count on {@link #onResume} being called after this method.
 *
 * <p>Note that {@link #getIntent} still returns the original Intent.  You
 * can use {@link #setIntent} to update it to this new Intent.
 *
 * @param intent The new intent that was started for the activity.
 *
 * @see #getIntent
 * @see #setIntent
 * @see #onResume
 */
@Override
protected void onNewIntent(Intent intent) {
    super.onNewIntent(intent);
    setIntent(intent);
    /** when we are back check here intent action for example or extras  */
}