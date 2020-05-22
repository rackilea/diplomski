Set<Event> events = eventService.findByUsers(user);
long totalTime = 0;
for(Event event : events)
{
   LocalTime startTime = event.getStart().toLocalTime();
   LocalTime endTime = event.getEnd().toLocalTime();

   long duration = Duration.between(startTime, endTime).toHours();
   System.out.println("The time bewtween shifts is " + duration);

   totalTime += duration;
}