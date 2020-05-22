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

        if(currentDate.before(date)) {    
            futureEvents.add(events); 
        }
    }

    adapter.filter(futureEvents); 
}