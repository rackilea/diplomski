public static void main(String[] args){

    ArrayList<Employee> al=new ArrayList<Employee>();

    Employee obj=new Employee("e01", "Shan", 222);
    Employee obj1=new Employee("e02", "viv", 600);
    Employee obj2=new Employee("e00", "arun", 100);

    al.add(obj);
    al.add(obj1);
    al.add(obj2);

    Collections.sort(al);

    Iterator i=al.iterator();
    while(i.hasNext()){
        Employee o1=(Employee)i.next();
        System.out.println("Sal: "+o1.getEsal());
    }

}