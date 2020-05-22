public interface ChildDao {

    @Cacheable(cacheName = "childDao")
    public List<Child> findAll();

}