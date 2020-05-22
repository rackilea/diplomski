@Singleton
    @Startup
    public class IDMInitializer{
    @Inject
    private PartitionManager partitionManager;

    @PostConstruct
    public void init(){
            Realm defaultReam = this.partitionManager.getPartition(Realm.class, "default");
            if (defaultReam==null){
                    System.out.println("Couldn't find default partition, creating default partition");
                    defaultRealm = new Realm("default");
                    this.partitionManager.add(defaultRealm);
            } else {
                    System.out.println("Found default partition");
            }
    }
    }