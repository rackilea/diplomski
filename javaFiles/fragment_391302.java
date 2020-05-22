public interface GenericDao<D>{

    public D get(Long id);// as Id use Long instead of Integer, Ids can be very large numbers, Int can be not enough

    public Collection<D> getList(SearchCriteria crit); //for retrieving more than one element 

    public void remove(Long id);

    public void update(D entity); // remember that updated record should have already id inside, you can add assert inside

    public void create(D entity); // assert that id is null
}