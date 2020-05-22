class User {
    private String name;
    private String email;
    private transient String password;
    private int width;
    private int height;

    public User() {
    }

    User(String name, String email, String password, int width, int height) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.width = width;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Float.compare(user.width, width) == 0 &&
                Float.compare(user.height, height) == 0 &&
                Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, width, height);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }
}