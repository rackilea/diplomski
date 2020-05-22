tb = new Timetable ();
    tb.setName(namesarray[k]);
    tb.setJobName(jobarray[k]); 
    tb.setEventName(rs.getString("eventName")); 
    tb.setDate(rs.getString("date"));
    tb.setLocation(rs.getString("location"));
    list.add(k, tb)