@Override
public Object getValueAt(Object arg0, int arg1) {
    if (arg0 instanceof Employee) {

        Employee emp = (Employee) arg0;
        return emp.getName();
    } else if (arg0 instanceof Departement) {
        Departement dept = (Departement) arg0;
        return dept.getName();
    }

    return null;
}