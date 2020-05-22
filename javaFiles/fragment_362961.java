class User {

    private String id;

    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User other = (User)obj;
            if (id.equals(other.id)) {
              return true;
            }
        }
        return false;
    }

    public String getId() {
        return id;
    }

}