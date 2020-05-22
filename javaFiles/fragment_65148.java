public class PeopleToAdd {
    @Exclude
    public String key;

    private String email;
    private String provider;

    public PeopleToAdd(String email, String provider) {
        this.email = email;
        this.provider = provider;
    }

    public PeopleToAdd() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}