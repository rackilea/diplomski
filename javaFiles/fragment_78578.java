public class ExampleUser implements Serializable {
    private final static long serialVersionUID = 20090127L;
    @XmlAttribute
    protected String name;
    @XmlAttribute
    protected String email;
    public final static ExampleUser EMPTY_INSTANCE = new ExampleUser() {
        private static final long serialVersionUID = 0L;
        @Override
        public void setName(java.lang.String value) { throw new UnsupportedOperationException(); }
        @Override
        public void setEmail(java.lang.String value) { throw new UnsupportedOperationException(); }
    };

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }
}

public class ExampleAccount implements Serializable {
    private final static long serialVersionUID = 20090127L;
    protected ExampleUser user;
    @XmlElement(name = "alias")
    protected List<String> aliases;
    @XmlAttribute
    protected String id;
    @XmlAttribute
    protected String name;
    public final static ExampleAccount EMPTY_INSTANCE = new ExampleAccount() {
        private static final long serialVersionUID = 0L;
        @Override
        public void setUser(com.boomi.platform.api.ExampleUser value) { throw new UnsupportedOperationException(); }
        @Override
        public List<String> getAliases() { return java.util.Collections.emptyList(); }
        @Override
        public void setId(java.lang.String value) { throw new UnsupportedOperationException(); }
        @Override
        public void setName(java.lang.String value) { throw new UnsupportedOperationException(); }
    };

    public ExampleUser getUser() {
        return user;
    }

    public void setUser(ExampleUser value) {
        this.user = value;
    }

    public List<String> getAliases() {
        if (aliases == null) {
            aliases = new ArrayList<String>();
        }
        return this.aliases;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public ExampleUser safeGetUser() {
        return (getUser() != null) ? getUser() : ExampleUser.EMPTY_INSTANCE;
    }
}