import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class JacksonProgram {

    public static void main(String[] args) throws Exception {
        String json = "{ ... }";
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.setPropertyNamingStrategy(new PropertyNamingStrategy.PropertyNamingStrategyBase() {
            @Override
            public String translate(String propertyName) {
                return propertyName.toLowerCase();
            }
        });

        System.out.println(mapper.readValue(json, Root.class));
    }
}

class Root {

    private List<ResourceDescription> resourcedescriptions;

    public List<ResourceDescription> getResourcedescriptions() {
        return resourcedescriptions;
    }

    public void setResourcedescriptions(List<ResourceDescription> resourcedescriptions) {
        this.resourcedescriptions = resourcedescriptions;
    }

    @Override
    public String toString() {
        return String.valueOf(resourcedescriptions);
    }
}

class ResourceDescription {

    private String path;
    private LocalDateTime lastModified;
    private String chartConfig;
    private final List<Tag> tags = new ArrayList<Tag>();
    private final List<Resource> resources = new ArrayList<Resource>();

    @JsonAnySetter
    public void setAnyValues(String propertyName, Object value) {
        if (propertyName.startsWith("tag_")) {
            if (value instanceof String) {
                tags.add(new Tag(propertyName, value.toString()));
            } else if (value instanceof List) {
                List<?> values = (List<?>) value;
                for (Object v : values) {
                    tags.add(new Tag(propertyName, v.toString()));
                }
            }
            // throw exception?
        } else {
            // handle another unknown properties
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getChartConfig() {
        return chartConfig;
    }

    public void setChartConfig(String chartConfig) {
        this.chartConfig = chartConfig;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public List<Resource> getResources() {
        return resources;
    }

    @Override
    public String toString() {
        return "ResourceDescription [path=" + path + ", lastModified=" + lastModified
                + ", chartConfig=" + chartConfig + ", tags=" + tags + ", resources=" + resources
                + "]";
    }
}

class Resource {

    private String lang;
    private String path;
    private String mimeType;
    private LocalDateTime lastModified;

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    @Override
    public String toString() {
        return "Resource [lang=" + lang + ", path=" + path + ", mimeType=" + mimeType
                + ", lastModified=" + lastModified + "]";
    }
}

class Tag {

    private String namespace;
    private String name;

    public Tag() {
    }

    public Tag(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tag [namespace=" + namespace + ", name=" + name + "]";
    }
}