@Override
public FlightLogEntry clone() {
    FlightLogEntry clone = (FlightLogEntry) super.clone();
    clone.attendants = new TreeMap<Person, Duty>();
    for( Person p : this.attendants.keySet() ) {
        clone.setAttendant(p, this.attendants.get(p));
    }
    return clone;
}