import com.datastax.driver.core.Cluster
import io.micronaut.context.ApplicationContext
import io.micronaut.context.event.BeanCreatedEvent
import io.micronaut.context.event.BeanCreatedEventListener
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Singleton

@Singleton
class ClusterBuilderListener implements BeanCreatedEventListener<Cluster.Builder> {
    private static final Logger LOG = LoggerFactory.getLogger(ClusterBuilderListener.class)

    @Override
    Cluster.Builder onCreated(BeanCreatedEvent<Cluster.Builder> event) {
        def builder = event.getBean()
        ApplicationContext applicationContext = (ApplicationContext) event.getSource()

        if(applicationContext.getEnvironment().getActiveNames().contains('pro') ){
            builder.withCredentials("username", "password")
        }
        return builder
    }
}