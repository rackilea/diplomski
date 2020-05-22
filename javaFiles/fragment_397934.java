class MyMainClass{
          public static void main(String[] args) {
          public int elements = 100000;
          ArrayList<Student> list = new ArrayList<Student>();
          Random rand = new Random();
          for (int i=0; i<elements; i++) {
                list.add(new Student(rand.nextInt(4)+2, rand.nextInt(900000)));
            }
          Collections.sort(list, new StudentComparator());

           }