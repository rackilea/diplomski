// public api in your custom model
public void removeEmployee(Departement dept, Employee emp) {
    TreePath path = new TreePath(new Object[] {depList, dept});
    int index = dept.empList.indexOf(emp);
    dept.empList.remove(emp);
    modelSupport.fireChildRemoved(path, index, emp);
}

// its usage in application code
TestModel model = (TestModel) rootTree.getModel();
model.removeEmployee(dept2, emp4);