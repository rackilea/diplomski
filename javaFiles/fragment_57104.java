import com.google.appengine.api.ThreadManager;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.annotation.Entity;
import org.reflections.Reflections;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * This class processes the classpath for classes with the @Entity or @Subclass annotations from Objectify
 * and registers them with the ObjectifyFactory, it is multi-threaded and works very fast!
 */
public class ObjectifyLoaderContextListener implements ServletContextListener
{
    private static final Logger L = LoggerFactory.getLogger(ObjectifyLoaderContextListener.class);

    private final Set<Class<?>> entities;

    public ObjectifyLoaderContextListener()
    {
        this.entities = new HashSet<>();
    }

    @Override
    public void contextInitialized(@Nonnull final ServletContextEvent sce)
    {
        final ExecutorService es = Executors.newCachedThreadPool(ThreadManager.currentRequestThreadFactory());
        cb.setExecutorService(es);
        final Reflections r = Reflections.collect();
        this.entities.addAll(r.getTypesAnnotatedWith(Entity.class));
        es.shutdown();
        final ObjectifyFactory of = ObjectifyService.factory();
        for (final Class<?> cls : this.entities)
        {
            of.register(cls);
            L.debug("Registered {} with Objectify", cls.getName());
        }
    }

    @Override
    public void contextDestroyed(@Nonnull final ServletContextEvent sce)
    {
        /* this is intentionally empty */
    }
}