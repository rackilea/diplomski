import static scala.collection.JavaConverters.asScalaBufferConverter;
import static java.util.Arrays.asList;

...

new ItemChain(asScalaBufferConverter(asList(new Item(), new Item())).asScala());