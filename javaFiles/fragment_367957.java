String lastName = null;
for (String name : names) {
  if (name.equals(lastName))
    break;
  lastName = name;
}