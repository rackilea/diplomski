public class YourRepo /* No Spring Data interface here! */ { 

    @Autowired
    private EntityManger entityManager;

    public add(Something entity) {
        entityManager.merge(entity);
    }
}