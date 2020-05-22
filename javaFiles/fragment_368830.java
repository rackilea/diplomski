String[] deps = {"Economy", "Management"};
ArrayList<Employee> emps = new ArrayList<>();

emp1 = new Employee("fistname","lastname",deps[1]);
//deps[1] - "Management"

for (int i = 0; i < deps.length; i++){
  System.out.println(deps[i] + " departement:");
  int count = 0;
  for(Employee e : emps){
     if(e.getDepartment().equals(deps[i])){
        System.out.println(e);
        count++;
     }
  }
  System.println(count + " employes in this department");
}