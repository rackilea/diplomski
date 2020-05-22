import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class Module extends AbstractModule {
  protected void configure() {

    bind(i1.class)
      .annotatedWith(Names.named("c1"))
      .to(c1.class);

    bind(i1.class)
      .annotatedWith(Names.named("c2"))
      .to(c2.class);
  }
}