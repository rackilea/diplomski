@Service
@Qualifier("foo")
public class FooHandler implements IHandler { ... }

@Service
@Qualifier("bar")
public class BarHandler implements IHandler { ... }

@Component
public class MyThing {
    @Autowired @Qualifier("foo")
    private IHandler handler;

    ...
}