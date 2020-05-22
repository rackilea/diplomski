public class ComparatorPractice{
    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<Student>();

        Student student1 = new Student(1, 90, 70, 100);
        Student student1 = new Student(2, 85, 43, 90);
        Student student1 = new Student(3, 67, 70, 80);

        students.add(student1);
        students.add(student2);
        students.add(student3);

       Collections.sort(students, new Comparator(){
           @Override
           public int compare(Object o1, Object o2){
               if (o1 instanceof Student && o2 instanceof Student){
                   if (o1.coursework1 > o2.coursework1)
                       return 1;
                   else if (o1.coursework1 == o2.coursework1)
                       return 0;
                   else
                        return -1;
               }
           }
       });

       System.out.println("Highest coursework1 mark is " 
                           + students.get(students.size()- 1).coursework1);

       Collections.sort(students, new Comparator(){
           @Override
           public int compare(Object o1, Object o2){
               if (o1 instanceof Student && o2 instanceof Student){
                   if (o1.coursework2 > o2.coursework2)
                       return 1;
                   else if (o1.coursework2 == o2.coursework2)
                       return 0;
                   else
                        return -1;
               }
           }
       });

       System.out.println("Highest coursework2 mark is " 
                           + students.get(students.size()- 1).coursework2);
    }
}