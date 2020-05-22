@PerApplication
public class RealmHelperRepo implements HelperRepo {
   private final RealmManager realmManager;

    @Inject
    public RealmHelperRepo(RealmManager realmManager) {
        this.realmManager = realmManager;
    }


    @Override
    public void save(Helper helper) {
        try(Realm realm = realmManager.openLocalInstance()) {
            realm.executeTransaction(r -> r.copyToRealmOrUpdate(helper)); 
        }
    }