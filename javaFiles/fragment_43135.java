@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "businessUnity")
public interface BusinessUnityRepository extends CouchbaseRepository<BusinessUnity, String>{

List<BusinessUnity> findByCompanyId(String companyId);

}