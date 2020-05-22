public class TreeController extends Controller
{

    public void createTree() throws IOException{
        MenuManager menuManager = MenuManager.getMenuManager(); 
        String mode = request().getQueryString("mode");
    String node = request().getQueryString("node");
    String hash = request().getQueryString("hash");
    TreeNodeDto treeObject = menuManager.buildTree();
    ok(treeObject.toJson());
    }

}

public class BaseDto<T extends BaseDto<T>> implements Serializable{

    public JsonNode toJson() {
        return Json.toJson(this);
    }

    public T fromJson(JsonNode jsonObject) {
        return (T) Json.fromJson(jsonObject, this.getClass());
    }
}

public static class TreeNodeDto extends BaseDto {
    public String hash;
    public String name;
    public Set<TreeNodeDto> children;

    // Override equals and hashcode, because we are using "set" to maintain the child nodes.

    }