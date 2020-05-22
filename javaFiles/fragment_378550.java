@Action(value="/PopulateStateList", results=@Result(type="json", params = {"contentType", "application/json", "root", "map"}))
public class AjaxMapAction extends ActionSupport {

  Long countryId; //getter and setter

  Map<String, String> map=new HashMap<String, String>();

  public Map<String, String> getMap() {
    return map;
  }

    @Override
    public String execute() throws Exception {

        map.put("1", "India");
        map.put("2", "America");
        map.put("3", "England");
        map.put("4", "Japan");
        map.put("5", "Germany");

        return SUCCESS;
    }
}