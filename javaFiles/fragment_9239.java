public static void main(String[] args) {
   int empSize = getNumberOfEmployees("employees.txt");
   employees = new Employee[empSize]; 
   employees = read("employees.txt");

    BST bst = new BST();
    for(Employee e : employees){
        bst.insert(e);
    }

}

public static int getNumberOfEmployees (String file) {

    int totalEmp = 0;
    try {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while((line = reader.readLine()) != null ) {
            totalEmp ++;
        }
    }catch (IOException e) {
        e.printStackTrace();
    }
    return totalEmp;
}

public static Employee[] read(String file) {
    try {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        int i=0;

        while((line = reader.readLine()) != null ){
            String[] arr = line.split("-");
            Employee emp = new Employee();
            emp.ccode = Integer.parseInt(arr[0]);
            emp.cus_name = arr[1];
            emp.phone = arr[2];
            employees[i] = emp;
            i++;
        }
        return employees;
    } catch (IOException ex) {
        Logger.getLogger(TestMusic.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}