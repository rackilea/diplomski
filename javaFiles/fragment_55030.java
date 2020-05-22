public boolean equals(Object o) {
  if (!(o instanceof Student)) {
    return false;
  }
  Student other = (Student) o;
  return name.equals(other.name) && id.equals(other.id) && GPA == other.GPA;
}

public int hashCode() {
  return name.hashCode();
}