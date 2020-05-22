import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Required dependencies for test
 * 
 *  <dependency>
 *      <groupId>org.glassfish.jersey.containers</groupId>
 *      <artifactId>jersey-container-grizzly2-http</artifactId>
 *      <version>2.23</version>
 *  </dependency>
 *  <dependency>
 *      <groupId>org.glassfish.jersey.media</groupId>
 *      <artifactId>jersey-media-json-jackson</artifactId>
 *      <version>2.23</version>
 *  </dependency>
 *
 * @author Paul Samsotha
 */
public class JacksonGenericTest extends JerseyTest {

    @XmlRootElement
    public static class Pair<K, V> {

        private K key;
        private V value;

        public Pair() {
        }

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Pair{" + "key=" + key + ", value=" + value + '}';
        }
    }

    @Path("test")
    @Consumes("application/json")
    @Produces("application/json")
    public static class TestResource {

        @POST
        public Pair create(Pair<Integer, String> pair) {
            return pair;
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(TestResource.class)
                // not required here since we don't have MOXy on the classpath,
                // but in Glassfish, you should make sure to register it
                // so it disables MOXy, since Glassfish has MOXy on the classpath.
                .register(JacksonFeature.class)
                .register(new LoggingFilter(Logger.getAnonymousLogger(), true));
    }

    private final String jsonData = "{\"key\":100,\"value\":\"value:100\"}";

    @Test
    public void postTest() {
        final Response response = target("test")
                .request()
                .post(Entity.json(jsonData));
        final Pair<Integer, String> pair = response.readEntity(
                new GenericType<Pair<Integer, String>>(){});
        assertThat(pair.getKey(), is(100));
        assertThat(pair.getValue(), is("value:100"));
    }
}