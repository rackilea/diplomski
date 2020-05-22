public void checkRemoval() {
    Iterator<Appointment> apptsIterator = appointments.iterator();
    while (apptsIterator.hasNext()){ 
        if (appts.next().resolved == true) 
            apptsIterator.remove(); //removes the last element you got via next()
    }