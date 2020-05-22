/**
 * Installs the given license key as the current license key.
 * If {@code key} is {@code null}, the current license key gets
 * uninstalled (but the cached license certificate is not cleared).
 */
protected synchronized void setLicenseKey(final byte[] key) {
    final Preferences prefs = getLicenseParam().getPreferences();
    if (null != key)
        prefs.putByteArray(PREFERENCES_KEY, key);
    else
        prefs.remove(PREFERENCES_KEY);
}