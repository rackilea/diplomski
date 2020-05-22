private enum  TestComparator implements Comparator<Test> {
 BY_NAME {

    @Override
    public int compare(Test o1, Test o2) {

       //We validate first against null

       return o1n.name.compareTo(o2.name);

    }               
  }
 BY_WHATEVER{

    @Override
    public int compare(Test o1, Test o2) {

       //We validate first against null
      return (o1.whatever<o2.whatever ? -1 : (o1.whatever==o2.whatever ? 0 : 1));
    }               
  }

}