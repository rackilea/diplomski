import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

public class MyModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(new TypeLiteral<Repository<User>>() {}).to(UserRepository.class);
  }
}