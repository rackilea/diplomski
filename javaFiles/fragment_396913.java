/* (non-Javadoc)
 * @see android.view.View#findViewById(int)
 * First look in our children, then in any header and footer views that may be scrolled off.
 */
@Override
protected View findViewTraversal(@IdRes int id) { ... }