public Object clone() {
    try {
        EmployeeList copy = (EmployeeList) super.clone();
        if (list!=null) {
            copy.list = new Employee[list.length];
            for (int i=0; i<list.length; i++) {
                copy.list[i] = (Employee)list[i].clone();
            }
        } else {
            copy.list = null;
        }
        return copy;
    } catch (CloneNotSupportedException c) {
        System.out.println(c);
        return null;
    }
}