import com.google.appengine.api.utils.SystemProperty;
import static com.google.appengine.api.utils.SystemProperty.environment;
import static com.google.appengine.api.utils.SystemProperty.Environment.Value.Development;
import static com.google.appengine.api.utils.SystemProperty.Environment.Value.Production;

SystemProperty.Environment.Value env = environment.value();
if (env  == Production) {
      //prod only code
      ...
} else if(env == Development) {
      //dev only code
      ...
}