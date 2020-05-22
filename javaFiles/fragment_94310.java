import com.google.inject.AbstractModule;
import com.google.inject.Exposed;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.PrivateModule;
import com.google.inject.Provides;
import com.google.inject.multibindings.Multibinder;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

import java.util.Set;

public class GuiceCircularDependencyTest {

    public static void main(String[] args) {
        Injector in = Guice.createInjector(new Owner());
        String result = in.getInstance(Key.get(String.class, Names.named("result")));
        System.out.println("Result is: " + result);
    }

    public static class Owner extends PrivateModule {
        @Override
        protected void configure() {
            Multibinder<String> multi = Multibinder.newSetBinder(binder(), String.class);
            install(new Integration());
            install(new ModuleWrapper<>(new ModuleA(), multi));
            install(new ModuleWrapper<>(new ModuleB(), multi));
            install(new ModuleWrapper<>(new ModuleC(), multi));
            expose(String.class).annotatedWith(Names.named("result"));
        }
    }

    public static class ModuleWrapper<T> extends AbstractModule {
        private final WrappablePrivateModule<T> inner;
        private final Multibinder<T> multi;

        public ModuleWrapper(WrappablePrivateModule<T> inner,
                             Multibinder<T> multi) {
            this.inner = inner;
            this.multi = multi;
        }

        @Override
        protected void configure() {
            install(inner);
            multi.addBinding().to(inner.getExposedKey());
        }
    }

    public static abstract class WrappablePrivateModule<T> extends PrivateModule {

        @Override
        protected void configure() {

        }

        public abstract Key<T> getExposedKey();
    }

    public static class ModuleA extends WrappablePrivateModule<String> {

        private static final String SUFFIX = "A";

        @Override
        public Key<String> getExposedKey() {
            return Key.get(String.class, Names.named(SUFFIX));
        }

        @Provides @Exposed @Named(SUFFIX)
        public String expose(Wrapper prefix) {
            return prefix + SUFFIX;
        }
    }

    public static class ModuleB extends WrappablePrivateModule<String> {

        private static final String SUFFIX = "B";

        @Override
        public Key<String> getExposedKey() {
            return Key.get(String.class, Names.named(SUFFIX));
        }

        @Provides @Exposed @Named(SUFFIX)
        public String expose(Wrapper prefix) {
            return prefix + SUFFIX;
        }
    }

    public static class ModuleC extends WrappablePrivateModule<String> {

        private static final String SUFFIX = "C";

        @Override
        public Key<String> getExposedKey() {
            return Key.get(String.class, Names.named(SUFFIX));
        }

        @Provides @Exposed @Named(SUFFIX)
        public String expose(Wrapper prefix) {
            return prefix + SUFFIX;
        }
    }

    public static class Integration extends PrivateModule {
        @Override
        protected void configure() {
            bind(Wrapper.class).toInstance(new Wrapper("Module"));
            expose(Wrapper.class);
        }

        @Provides @Exposed @Named("result")
        public String go(Set<String> in) {
            return in.toString();
        }
    }

    public static class Wrapper {
        private final String prefix;

        public Wrapper(String prefix) {
            this.prefix = prefix;
        }

        @Override
        public String toString() {
            return prefix;
        }
    }
}