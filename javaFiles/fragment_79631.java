public static void main(String[] args) {
    List<Employee> employees = read("employees.txt");

    BST bst = new BST();
    for(Employee e : employees){
        bst.insert(e);
    }

}

public static List<Employee> read(String file) {
    try {
        List<Employee> employees = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null ){
            String[] arr = line.split("-");
            Employee emp = new Employee();
            emp.ccode = Integer.parseInt(arr[0]);
            emp.cus_name = arr[1];
            emp.phone = arr[2];
            employees.add(emp);
        }
        return employees;
    } catch (IOException ex) {
        Logger.getLogger(TestMusic.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}