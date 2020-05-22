@Override
public boolean equals(Object object) {
  boolean result = false;
  if (object == null || object.getClass() != getClass()) {
    result = false;
  } else {
    Person person = (Person) object;
    if (this.nationalIdentityNumber == person.nationalIdentityNumber) {
      result = true;
    }
  }
  return result;
}