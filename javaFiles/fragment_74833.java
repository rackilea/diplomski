public void futureEvents() {
    ArrayList<Events> futureEvents = new ArrayList<>();
    Date currentDate = new Date();

    for(Events events : eventsList) {    
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = null;
        try { 
            date = formatter.parse(events.getEventDate() + " " + events.getEventTime());
        } catch (ParseException e) {

        }

        Date thresholdDate = currentDate.clone(); //makes a copy of the currentDate object
        thresholdDate.setMinutes(thresholdDate .getMinutes() + 30);//Modify minutes to 30 minutes in future.

        if(currentDate.before(date) && date.before(thresholdDate)) {    
            futureEvents.add(events); 
        }
    }

    adapter.filter(futureEvents); 
}