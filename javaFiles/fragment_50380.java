static class Holder {
    public Date date;

    public Holder(Date d) {
        super();
    }
}

List<Holder> list= Arrays.asList(new Holder(new Date()));

// creates a Stream<Holder> having the list as the source
Stream<Holder> s1 = list.stream();

// creates a Stream<Date> by taking the previous elements from the Stream
// and mapping those to `Date date`
Stream<Date> s2 = s1.map(u -> u.date);

// consumes the stream by invoking max using the compareTo method
// two Date objects are Comparable by invoking compareTo 
Optional<Date> optionalDate = s2.max(Date::compareTo);

// gets the maxValue from that Optional
// if the initial list is empty, your last get will throw a NoSuchElementException
Date maxDate = optionalDate.get();