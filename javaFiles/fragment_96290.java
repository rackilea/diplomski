final ArgumentCaptor<Person> personCaptor = forClass(Person.class);
final ArgumentCaptor<Room> roomCaptor = forClass(Room.class);
 PowerMockito.verifyNew(Planner.class)
             .withArguments(eq(1),eq(6),eq(11),eq(13), 
                  personCaptor.capture(), 
                  roomCaptor.capture(), 
                  eq("description"));

    final Person passedParam = personCaptor.getValue();
    //do your comparison here