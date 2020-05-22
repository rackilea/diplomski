public interface MotherDao {
    @Cacheable(cacheName = "motherDao")
    public List<Mother> findAll();

    @TriggersRemove(cacheName={"motherDao", "childDao"})
    public void delete(Integer pk);
}