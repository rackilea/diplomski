enum Grades
  {
    SIXTH_GRADE, SEVENTH_GRADE;
  }

  public static void main(String[] args) throws IOException
  {
    Map<Grades, List<String>> literature = new HashMap<Grades, List<String>>();
    literature.put(Grades.SIXTH_GRADE, new ArrayList<String>(Arrays.asList("Learning Ratio and Proportion Concepts and practice assessment","Number System")));
    literature.put(Grades.SEVENTH_GRADE, new ArrayList<String>(Arrays.asList("Equations and expression","Geometry")));

    // get books for 6th grade
    List<String> books6th = literature.get(Grades.SIXTH_GRADE);

    for (String book : books6th)
      System.out.println(book);

    // get books for 7th grade
    List<String> books7th = literature.get(Grades.SEVENTH_GRADE);

    Collection<List<String>> allBooks = literature.values(); // tname data
    Set<Grades> allGrades = literature.keySet(); // data associated with gname
  }