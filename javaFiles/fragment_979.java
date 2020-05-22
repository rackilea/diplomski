@Validated
@Service
public class DocService {
  public HTMDoc create(@Valid HTMDoc doc) {
    return repository.save(doc);
  }
}