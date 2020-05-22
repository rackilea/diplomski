public class User {
    private String selectedScreenName;
    private List<SelectItem> availableScreenNames;

    public User() {
        availableScreenNames = new ArrayList<SelectItem>();
        for (String availableScreenName: session.createQuery(SQL).list()) {
            availableScreenNames.add(new SelectItem(availableScreenName));
        }
    }

    // ...
}