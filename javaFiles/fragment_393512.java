public class ChartParameters {
    private Map<String,Object> params = new HashMap<String,Object>();

    public Object getParam(String paramName) {
        return params.get(paramName);
    }

    //Add here more methods... maybe a CTOR that takes a map of params,
    //And a method to add a parameter
}