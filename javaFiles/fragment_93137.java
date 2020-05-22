/**
 * Called by {@link #setTheme} and {@link #getTheme} to apply a theme
 * resource to the current Theme object.  Can override to change the
 * default (simple) behavior.  This method will not be called in multiple
 * threads simultaneously.
 *
 * @param theme The Theme object being modified.
 * @param resid The theme style resource being applied to <var>theme</var>.
 * @param first Set to true if this is the first time a style is being
 *              applied to <var>theme</var>.
 */
protected void onApplyThemeResource(Resources.Theme theme, int resid, boolean first) {
    theme.applyStyle(resid, true);
}