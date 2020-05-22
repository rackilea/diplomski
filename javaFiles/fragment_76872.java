class Student implements Comparable<Student> {
   private String name;
   private int grade = 0;

   public Student( String name ) {
        this.name = name;
   }

   public void setGrade( int grade ) {
        this.grade = grade;
   }

   // In addition, you'll have getName(), getGrade(),
   // and possibly a good `toString()` for printing a
   // student record.

   @Override
   public int compareTo( Student otherStudent ) {
       return this.name.compareTo( otherStudent.name );
   }
}