values.put(Attendees.ATTENDEE_STATUS, "1"); 

    String selectedEventId = eventStructure.getString("mEventId");
    String selectedEmail = "aaa.bbb@gmail.com";

    String[] selArgs = new String[]{selectedEventId, selectedEmail};
    int updated = cr.update(
                Attendees.CONTENT_URI, 
                   values, 
                   Attendees.EVENT_ID + " =? AND " + Attendees.ATTENDEE_EMAIL + " =?", 
                   selArgs);

    Log.d(TAG, "sendAcceptEvent :: updated row count: "+ updated);