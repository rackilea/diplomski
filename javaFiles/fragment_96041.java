public int compareTo(Person to) {
  int cmp = this.lastName.compareTo(to.lastName);
  if (cmp == 0)
    cmp = this.firstName.compareTo(to.firstName);
  return cmp;
}