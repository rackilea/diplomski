public class Spinner {
    private Map<String, String> nameMap = new HashMap<String, String>();

    // associate an email with a given name
    public void setEmail(String name, String email) {
        nameMap.put(name, email);
    }

    // obtain an email associate with a given name
    public void getEmail(String name) {
        return nameMap.get(name);
    }
}