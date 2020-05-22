@RestResource(path="questions")
public interface QuestionRepository extends RestRepositoryMethodExportedFalse<Question,Long>{

/**
 * Here is the only method I expose
 */
@RestResource(exported = true)
@Override
Question findOne(Long id);

}