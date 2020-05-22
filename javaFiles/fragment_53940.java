import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

public class LocationData {

    @JacksonXmlElementWrapper(useWrapping=false)
    private List<VerticesData> vertices;

    public List<VerticesData> getVertices() {
        return vertices;
    }

    public void setVertices(List<VerticesData> vertices) {
        this.vertices = vertices;
    }

    @Override
    public String toString() {
        return "LocationData [vertices=" + vertices + "]";
    }

}