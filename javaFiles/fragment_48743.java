public class CustomComparator implements Comparator {
  public int compare(Object aObjectOne, Object aObjectTwo) {
    Item objectOne = (Item) aObjectOne;
    Item objectTwo = (Item) aObjectTwo;

    int cmpinstr = objectOne.getInstructor().compareTo(objectTwo.getInstructor());
    if (cmpinstr != 0) // different instructor
        return cmpinstr;

    int cmpcourse = objectOne.getCourse().compareTo(objectTwo.getCourse());
    if (cmpcourse != 0) // different course
        return cmpcourse;

    int cmpgroup = objectOne.getGroup().compareTo(objectTwo.getGroup());
    if (cmpgroup != 0) // different group
        return cmpgroup;

    // sorting by result.
    if (objectOne.getResult() < objectTwo.getResult())
        return -1; // i1 has lower result than i2
    else if (objectOne.getResult() > objectTwo.getResult())
        return 1; // i1 has higher result than i2

    return 0; // i1 and i2 have the same result
  }
}