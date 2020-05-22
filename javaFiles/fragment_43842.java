@Override
  public boolean equals(Object obj) {
      if (obj == null || obj.getClass() != this.getClass()) {
          return false;
      }
      PreparationContent other = (PreparationContent)obj;
      return this.id = other.id;
  }

  @Override
  public int hashCode() {
      // if id is long then return Long.valueOf(id).hashCode();
      return id;
  }