public class AlarmManager {
    public static final String ALARM_CLI_FORMAT = "startalarm:";
    public static SupportedOS currentOS = SupportedOS.UNSUPPORTED_OS;

    public enum SupportedOS {
        UNSUPPORTED_OS,
        MAC_OS,
        WINDOWS,
    }

    public AlarmManager() {
        final String osName = System.getProperty("os.name");
        if (osName == null) {
            L.e("Unable to retrieve OS!");
        } else if ("Mac OS X".equals(osName)) {
            currentOS = SupportedOS.MAC_OS;
        } else if (osName.contains("Windows")) {
            currentOS = SupportedOS.WINDOWS;
        } else {
            L.e("Unsupported OS: "+osName);
        }
    }

    /**
     * Windows only: name of the scheduled task
     */
    private String getAlarmName(final long alarmId) {
        return new StringBuilder("My_Alarm_").append(alarmId).toString();
    }

    /**
     * Gets the command line to trigger an alarm
     * @param alarmId
     * @return
     */
    private String getAlarmCommandLine(final long alarmId) {
        return new StringBuilder("javaws -open ").append(ALARM_CLI_FORMAT).append(alarmId).append(" ").append(G.JNLP_URL).toString();
    }

    /**
     * Adds an alarm to the system list of scheduled tasks
     * @param when
     */
    public void createAlarm(final Calendar when) {
        // Create alarm
        // ... stuff here
        final long alarmId = 42;

        // Schedule alarm
        String[] commandLine;
        Process child;
        final String alarmCL = getAlarmCommandLine(alarmId);
        try {
            switch (currentOS) {
            case MAC_OS:
                final String cron = new SimpleDateFormat("mm HH d M '*' ").format(when.getTime()) + alarmCL;

                commandLine = new String[] {
                        "/bin/sh", "-c",
                        "crontab -l | (cat; echo \"" + cron + "\") | crontab"
                };
                child = Runtime.getRuntime().exec(commandLine);
                break;

            case WINDOWS:
                commandLine = new String[] {
                        "schtasks",
                        "/Create",
                        "/ST "+when.get(Calendar.HOUR_OF_DAY) + ":" + when.get(Calendar.MINUTE),
                        "/SC ONCE",
                        "/SD "+new SimpleDateFormat("dd/MM/yyyy").format(when.getTime()), // careful with locale here! dd/MM/yyyy or MM/dd/yyyy? I'm French! :)
                        "/TR \""+alarmCL+"\"",
                        "/TN \""+getAlarmName(alarmId)+"\"",
                        "/F",
                };
                L.d("create command: "+Util.join(commandLine, " "));
                child = Runtime.getRuntime().exec(commandLine);
                break;
            }
        } catch (final IOException e) {
            L.e("Unable to schedule alarm #"+alarmId, e);
            return;
        }

        L.i("Created alarm #"+alarmId);
    }

    /**
     * Removes an alarm from the system list of scheduled tasks
     * @param alarmId
     */
    public void removeAlarm(final long alarmId) {
        L.i("Removing alarm #"+alarmId);
        String[] commandLine;
        Process child;
        try {
            switch (currentOS) {
            case MAC_OS:
                commandLine = new String[] {
                        "/bin/sh", "-c",
                        "crontab -l | (grep -v \""+ALARM_CLI_FORMAT+"\") | crontab"
                };
                child = Runtime.getRuntime().exec(commandLine);
                break;

            case WINDOWS:
                commandLine = new String[] {
                        "schtasks",
                        "/Delete",
                        "/TN \""+getAlarmName(alarmId)+"\"",
                        "/F",
                };
                child = Runtime.getRuntime().exec(commandLine);
                break;
            }
        } catch (final IOException e) {
            L.e("Unable to remove alarm #"+alarmId, e);
        }
    }

    public void triggerAlarm(final long alarmId) {
        // Do stuff
        //...
        L.i("Hi! I'm alarm #"+alarmId);

        // Remove alarm
        removeAlarm(alarmId);
    }
}