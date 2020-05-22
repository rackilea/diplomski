public static void main (String ... args){
        Set<Student> stSet= new HashSet<Student>();
        stSet.add(new Student("name1", 7));
        stSet.add(new Student("name3", 6));
        stSet.add(new Student("name1", 5));
        stSet.add(new Student("name1", 5));
        stSet.add(new Student("name1", 1));
        stSet.add(new Student("name1", 10));
        stSet.add(new Student("name1", 2));
        stSet.add(new Student("name1", 9));
        stSet.add(new Student("name1", 4));
    }
}