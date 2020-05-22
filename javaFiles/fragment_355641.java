import java.util.*;
import com.fasterxml.jackson.annotation.*;

public class Resource extends BaseResource{
    private String name;

    @JsonProperty("sub_resource_id")
    @JsonId
    private SubResource subResource;

    @JsonProperty("sub_resource_ids")
    @JsonId
    private List<SubResource> subResources;

    //getters and setters
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public SubResource getSubResource() {return subResource;}
    public void setSubResource(SubResource subResource) {this.subResource = subResource;}

    public List<SubResource> getSubResources() {return subResources;}
    public void setSubResources(List<SubResource> subResources) {this.subResources = subResources;}
}