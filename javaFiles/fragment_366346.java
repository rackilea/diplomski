Person first = persons.iterator().next();
for (Person other : persons) {
    if (other.compareTo(first) != 0) {
        return false;
    }
}
return true;