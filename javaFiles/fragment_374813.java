import java.util.List;
import java.util.Map;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix ="storage")
public class MyProps {

private List<String> listProp;
private Map<String, String> mapProp;

public List<String> getListProp() {
    return listProp;
}
public void setListProp(List<String> listProp) {
    this.listProp = listProp;
}
public Map<String, String> getMapProp() {
    return mapProp;
}
public void setMapProp(Map<String, String> mapProp) {
    this.mapProp = mapProp;
   }
}