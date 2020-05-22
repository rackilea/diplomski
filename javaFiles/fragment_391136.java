public static void main(final String[] args) {
    if (args.length >= 2 && args[1] != null && args[1].contains(AlarmManager.ALARM_CLI_FORMAT)) {
        try {
            final long alarmId = Long.parseLong(args[1].replace(AlarmManager.ALARM_CLI_FORMAT, ""));
            final AlarmManager m = new AlarmManager();
            m.triggerAlarm(alarmId);
        } catch (final NumberFormatException e) {
            L.e("Unable to parse alarm !", e);
        }
    }
}