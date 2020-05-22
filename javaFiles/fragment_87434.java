@Service
@Transactional(rollbackFor = Exception.class)
public class StorageEntryService {

    @Autowired
    private StorageEntryRepository storageEntryRepository;

    @PersistenceContext(unitName = "target")
    private EntityManager targetEntityManager;

    public void save(StorageEntry storageEntry) throws Exception {

        // this.storageEntryRepository.save(storageEntry);

        // Load an stored entry from the source database
        StorageEntry storedEntry = this.storageEntryRepository.findOne(12L);                
        //this.storageEntryRepository.save(storageEntry);
        // Save also to a different database
        final Session targetHibernateSession = targetEntityManager.unwrap(Session.class);
        Criteria criteria = targetHibernateSession.createCriteria(StorageEntry.class);

        criteria.add(Restrictions.like("someValue", "%Book1%"));
        List<StorageEntry> storageEntries = criteria.list();

        if (storageEntries.isEmpty()) {
            targetEntityManager.merge(storedEntry);
            // No flush then nodata is saved in the different database
            targetHibernateSession.flush();
            System.out.println("Stored the new object to target database.");
        } else {
            System.out.println("Object already existed in target database.");
        }


    }
}