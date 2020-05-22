public class MyResponseClass implements Serializable {  
@Expose
@SerializedName("id")
private String objectId;
@Expose
@SerializedName("module_name")
private String moduleName;
@Expose
@SerializedName("name_value_list")
private ValuesList valuesList;
//getters / setters for everything
}