public class Account {
    @JsonProperty("memberEmails")
    private Map<Integer, String> memberEmails = Maps.newHashMap();

    public Account() {
        super();
    }

    public void setMemberEmails(Map<Integer, String> memberEmails) {
        this.memberEmails = memberEmails;
    }

    @JsonIgnore
    public Map<Integer, String> getMemberEmails() {
        return Collections.unmodifiableMap(memberEmails);
    }
}