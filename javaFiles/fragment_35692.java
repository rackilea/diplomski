new TreeMap<>(new Comparator<XMLGregorianCalendar>() {
    @Override
    public int compare(XMLGregorianCalendar cal1, XMLGregorianCalendar cal2) {
        return cal1.compare(cal2);
    }
})