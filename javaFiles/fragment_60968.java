@Service
public class FooService {
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<Foo> findAll() { ... }
    ...
}