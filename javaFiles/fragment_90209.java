@Test
public void test() {
    List<String> events = Arrays.asList("Mark 45 G", "Rob 4 Y", "Jude Tom 6 R");
    List<Event> orderedEvents = events.stream()
            .map(eventString -> new Event(eventString))
            .sorted(Comparator.comparingInt(Event::getTime))
            .collect(Collectors.toList());
    System.out.println(orderedEvents);
}