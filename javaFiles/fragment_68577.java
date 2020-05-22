@Repository
public interface CompanyRepository extends CompanyOperations, MongoRepository<Company, String>{
} 

public interface CompanyOperations {
    Job findByJobId(String jobId);
}

public class CompanyRepositoryImpl implements CompanyOperations {
    @Autowired private MongoTemplate mongoTemplate;

    @Override
    public Job findByJobId(String jobId){
        Company company = mongoTemplate.findOne(new Query(Criteria.where("jobs.id").is(jobId)), Company.class);
        return company.getJobById(jobId); //implement this method in `Company` and save yourself some trouble.
    }
}