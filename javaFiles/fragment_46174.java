class CarHorsePowerComparator implements Comparator<Student> {
            public int compare(Student stu, Student stu1) {
                int sort;
                // Sort on Name first 
                sort = stu.getName().compareTo(stu1.getName);
                if(sort == 0){
                  // If name is equal, sort on city
                  sort = stu.getCity().compareTo(stu1.getCity);
                }   
                if(sort == 0){
                  // If name and city is equal, sort on Roll
                  sort = Integer.compare(stu.getRoll(),stu1.getRoll());
                } 
                return sort;
            }
}