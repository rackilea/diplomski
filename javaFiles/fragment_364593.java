Class A
{

    private IEmpHandler handler;

    public void setEmpHandler(IEmpHandler handler) {
        this.handler = handler;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void processEmployees(List<Employee> empList)
    {
        for (Employee emp : empList) 
            handler.processEmployee(emp);
    }
}

class EmpHandler implements IEmpHandler {
    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void processEmployee(...) {
    }
}