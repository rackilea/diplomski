import java.util.logging.Logger;
import org.glassfish.jersey.filter.LoggingFilter;
...
public void run(MyApplicationConfiguration conf, Environment env) throws Exception {
    // do your stuff and then add LoggingFilter
    env.jersey().register(new LoggingFilter(
                     Logger.getLogger(LoggingFilter.class.getName()),
                     true)
                 );
}