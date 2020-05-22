public interface FooService { void foo(); }
class FooServiceImpl implements FooService { @Override void foo() ...
enum FooServiceProvider implements FooService {
   INSTANCE;
   private final FooService impl  = new FooServiceImpl();
   @Override foo() { impl.foo()