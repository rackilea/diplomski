Intent i = new Intent();

//Froyo or greater (mind you I just tested this on CM7 and the less than froyo one worked so it depends on the phone...)
cn = new ComponentName("com.google.android.calendar", "com.android.calendar.LaunchActivity");

//less than Froyo
cn = new ComponentName("com.android.calendar", "com.android.calendar.LaunchActivity");

i.setComponent(cn);
startActivity(i);