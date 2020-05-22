//in EmployeeStore
public Employee get(String name){
    return map.get(name);
}

//in any class with reference to an EmployeeStore "store"
store.get(name).editSomething(something);