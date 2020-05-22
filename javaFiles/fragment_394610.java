StringBuilder sb = new StringBuilder("SETTINGS_SECURE\n");

sb.append(Settings.Secure.ADB_ENABLED.toUpperCase())
    .append("=")
    .append(Settings.Secure.getString(getContentResolver(),
        Settings.Secure.ADB_ENABLED))
    .append("\n")

    .append(Settings.Secure.ALLOWED_GEOLOCATION_ORIGINS.toUpperCase())
    .append("=")
    .append(Settings.Secure.getString(getContentResolver(),
        Settings.Secure.ALLOWED_GEOLOCATION_ORIGINS))
    .append("\n")

    .append(Settings.Secure.ALLOW_MOCK_LOCATION.toUpperCase())
    .append("=")
    .append(Settings.Secure.getString(getContentResolver(),
        Settings.Secure.ALLOW_MOCK_LOCATION))
    .append("\n")

    .append(Settings.Secure.ANDROID_ID.toUpperCase())
    .append("=")
    .append(Settings.Secure.getString(getContentResolver(),
        Settings.Secure.ANDROID_ID));