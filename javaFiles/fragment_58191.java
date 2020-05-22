public class User {

    public String name;

    public String validate() {
        name.trim
        if(name == "") {
            return "Name is required";
        }
        return null;
    }
}