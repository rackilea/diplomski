class EmployeeComparator implements Comparator<Employee>{

   public int compareTo(Employee o1,Employee o2){
       return o1.lastName.compareTo(o2.lastNam);
   }

}