@GET
@Path("/TheListOfPeople")
public People getListOfPeople() { 
    People people = new People();
    people.getPerson().addAll(dao.getList()); // or something like it

    return people ;
}