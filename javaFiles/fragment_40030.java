import java.util.*;
  import com.google.inject.*;

  public class Main {

    public static class Super {
      private static Map<Class<?>,Integer> map = new HashMap<Class<?>,Integer>();

      private Integer value;

      public Super(Object... args) {
        value = map.get(getClass());
        value = value == null ? 0 : ++value;
        map.put(getClass(), value);

        if(args.length > 0)
          System.out.println("Created " + this + " with " + Arrays.toString(args));
      }

      @Override
      public final String toString() {
        return "" + getClass().getSimpleName().charAt(0) + value;
      }
    }

    public interface A { }  
    public static class AImpl extends Super implements A  { } 

    public interface B { }  
    public static class BImpl extends Super implements B {
      @Inject public BImpl(C c, D d) { super(c,d); }
    }

    public interface C { }  
    public static class CImpl extends Super implements C  {
      @Inject public CImpl(A a) { super(a); }
    }

    public interface D { }  
    public static class DImpl extends Super implements D {
      @Inject public DImpl(A a) { super(a); }
    }

    public static class MyModule extends AbstractModule {
      @Override
      protected void configure() {} 

  // >>>>>>>>
      @Provides
      B builder( Injector injector ) {
        return injector.createChildInjector( new SubModule() ).getInstance( BImpl.class );
      }
  // <<<<<<<<
    }

  // >>>>>>>>
    public static class SubModule extends AbstractModule {
      @Override
      protected void configure() {
        bind(A.class).to(AImpl.class).in( Scopes.SINGLETON );
        bind(C.class).to(CImpl.class);      
        bind(D.class).to(DImpl.class);      
      }    
    }
  // <<<<<<<<

    public static void main(String[] args) {
      Injector inj = Guice.createInjector(new MyModule());
      inj.getInstance(B.class);    
      inj.getInstance(B.class);    
    }  
  }