public static void restore(Context context) {
    boolean enableHardwareKeys = Settings.System.getInt(context.getContentResolver(),
            Settings.System.HARDWARE_KEYS_ENABLED, 1) == 1;
    Settings.System.putInt(context.getContentResolver(),
        Settings.System.HARDWARE_KEYS_ENABLED, enableHardwareKeys ? 1 : 0);
}