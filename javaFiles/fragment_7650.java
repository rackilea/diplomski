@Transactional
public class PeopleService {

    ....
    private PeopleDAO pDAO;
    private CityDAO cDAO;

    ...

    public void createPerson(String name, String city)
     throws PeopleServiceException {
        Person p = new Person();
        p.setName(name);

        City c = cDAO.getCityByName(city);
        if (c == null) throw new ServiceException(city + " doesn't exist!");
        if (c.isFull()) throw new ServiceException(city + " is full!");
        c.addPeople(p);

        sess().save(p);
        sess().save(c);
    }

    ...
}