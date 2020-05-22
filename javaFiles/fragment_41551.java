import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.name.Names;
import javax.inject.Inject;

public class Main {
  static class Holder {
    @Inject @javax.inject.Named("foo")
    String javaNamed;
    @Inject @com.google.inject.name.Named("foo")
    String guiceNamed;
  }

  public static void main(String[] args) {
    Holder holder = Guice.createInjector(new AbstractModule(){
      @Override
      protected void configure() {
        // Only one injection, using c.g.i.Names.named("").
        bind(String.class).annotatedWith(Names.named("foo")).toInstance("foo");
      }

    }).getInstance(Holder.class);
    System.out.printf("javax.inject: %s%n", holder.javaNamed);
    System.out.printf("guice: %s%n", holder.guiceNamed);
  }
}