import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
public class AdminApplication extends Application {
HashSet<Object> singletons = new HashSet<Object>();
public AdminApplication() {
    singletons.add(new PersonService());
}
@Override
public Set<Class<?>> getClasses() {
    HashSet<Class<?>> set = new HashSet<Class<?>>();
    return set;
}
@Override
public Set<Object> getSingletons() {
    ObjectMapper mapper = new ObjectMapper();
    AnnotationIntrospector primary = new JacksonAnnotationIntrospector();
    AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
    mapper.setAnnotationIntrospectors(primary, secondary);
    JacksonJsonProvider jaxbProvider = new JacksonJsonProvider();
    jaxbProvider.setMapper(mapper);
    singletons.add(jaxbProvider);
    Swagger2Feature feature = new Swagger2Feature();
    feature.setContact("Pablo Garcia");
    feature.setDescription("api Description");
    feature.setPrettyPrint(true);
    feature.setTitle("api title");
    singletons.add(feature);
    return singletons;
  }
}