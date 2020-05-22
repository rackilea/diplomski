@Test
public void getAllAttends(){

    Iterable<Attends> allAttends = attendsRepository.findAll();
    allAttends.forEach(attend -> {
        System.out.println(attend);
    });

}

@Test
public void getAttendsByPerson(){

    String personId = "283f51e9-9ade-4f46-a005-7353b5211c8b";

    Iterable<Attends> allAttends = attendsRepository.findByPersonId(personId);
    allAttends.forEach(attend -> {
        System.out.println(attend);
    });

}