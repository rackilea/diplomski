public class Contact {
    String fname;
    String lname;

    public Contact(JSONObject obj){
        System.out.println(obj);
        try {
            fname = (String)obj.get("first_name");
            lname = (String)obj.get("last_name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
//get and set methods
}