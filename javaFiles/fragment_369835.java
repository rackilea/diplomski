class User {
    private String id;
    private String name;

    public String getId() {
      return id;
    }

    public void setId(String id) {
      this.id = id;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    // this uses reflection to get the first non-null field
    // you can modify it to return a list of non-null fields
    // in the case I've misunderstood the point
    public Field getFirstNonNullField() {
      for (Field f : getClass().getDeclaredFields()) {
        f.setAccessible(true);
        try {
          if (f.get(this) != null)
            return f;
        } catch (IllegalArgumentException | IllegalAccessException e) {
          // TODO handle this exception as you want
          e.printStackTrace();
        }
      }
      return null;
    }
}