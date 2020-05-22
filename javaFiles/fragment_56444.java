public int compare(Test o1, Test o2) {
  int result = o1.firstname.compareTo(o2.firstname);
  if (result == 0)
    return o1.secondname.compareTo(o2.secondname));
  else
    return result;
}