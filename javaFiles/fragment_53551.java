ArrayList<Student> al = new ArrayList<Student>();
al.add(new Student(101, "Vijay", 23));
al.add(new Student(106, "Ajay", 27));
al.add(new Student(105, "Jai", 21));

Map<Character, ArrayList<Student>> hm = new TreeMap<String, ArrayList<Student>>();

for (Student student : al) {
    Character key = student.name.charAt(0);
    ArrayList<Student> list = hm.get(key);  // get the existing list
    if (list == null) {
        list = new ArrayList<Student>();
    }
    list.add(student);  // add this student to it
    hm.put(key, list);  // replace it in the map, under the correct key
}