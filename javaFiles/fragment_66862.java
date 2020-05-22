public static void sort(List<Person> ps, String property, final boolean asc) {

  if (property.equals("userName")) {
    Collections.sort(ps, new Comparator<Person>() {

        public int compare(Person o1, Person o2) {
            // pls use appropriate compareTo I always get confused
            // which one to call when it is asc or desc.
            if (asc)
                return o1.getUserName().compareTo(o2.getUserName());
            else
                return o2.getUserName().compareTo(o1.getUserName());
        }
    });
  }

  if (property.equals("age")) {
    Collections.sort(ps, new Comparator<Person>() {

        public int compare(Person o1, Person o2) {

            if (asc)
                return o1.getAge().compareTo(o2.getAge());
            else
                return o2.getAge().compareTo(o1.getAge());
        }
    });
  }
}