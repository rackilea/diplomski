public void createAlarm(){
        Alarm al = new Alarm();
        Alarm.insertAlarm(al);
    }

    public static insertAlarm(Alarm al){
        alarms.add(al);
    }