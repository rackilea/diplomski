private void restartSelf() {   
    AlarmManager am = (AlarmManager)   getActivity().getSystemService(Context.ALARM_SERVICE);  
    am.set(AlarmManager.RTC_WAKEUP, Calendar.getInstance().getTimeInMillis() + 500, // one second   
            PendingIntent.getActivity(getActivity(), 0, getActivity().getIntent(), PendingIntent.FLAG_ONE_SHOT
                    | PendingIntent.FLAG_CANCEL_CURRENT));  
    Intent i = getActivity().getBaseContext().getPackageManager()
            .getLaunchIntentForPackage(getActivity().getBaseContext().getPackageName());  
    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  
    startActivity(i);  
}