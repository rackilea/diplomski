import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

public class JsonApp {

  public static void main(String[] args) throws Exception {
    MapperFactory mapperFactory = new MapperFactory();

    System.out.println("JSON:");
    System.out.println(mapperFactory.getJsonMapper().writeValueAsString(new Entity()));

    System.out.println("XML:");
    System.out.println(mapperFactory.getXmlMapper().writeValueAsString(new Entity()));

    System.out.println("CSV:");
    CsvMapper csvMapper = mapperFactory.getCsvMapper();
    CsvSchema schema = csvMapper.schemaFor(Entity.class).withHeader();
    System.out.println(csvMapper.writer(schema).writeValueAsString(new Entity()));
  }
}

class Entity {
  private int id = 12;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "A{" + "id=" + id + '}';
  }
}

interface EntityMixIn {

  @JsonProperty("_idName")
  int getId();
}