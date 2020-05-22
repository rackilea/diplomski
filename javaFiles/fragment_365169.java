Long nIdLong = System.currentTimeMillis();
        String nId = nIdLong.toString();
Intent alarmIntent = new Intent(context, AlarmReceiver.class);
                alarmIntent.putExtra("nID", nIdLong);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0,  alarmIntent , 0);

                AlarmManager alarmManager = (AlarmManager)getActivity().getSystemService(getActivity().ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);