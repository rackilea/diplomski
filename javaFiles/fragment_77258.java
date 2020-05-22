public class BradfordReport {
    EmployeeRow _empRow = new EmployeeRow();
    ArrayList<EmployeeRow> _bradfordData = new ArrayList<EmployeeRow>();

    public void Run() {
       // processing to setup Employee row variables
       for (int x=0; x<10; x++) {
           // create a NEW INSTANCE of an EmployeeRow
           _empRow = new EmployeeRow();
           _empRow.EmpNum = x; // etc for other variable in EmployeeRow
           _bradfordData.add(_empRow);
       }
    }
    // THE RESULT IN _bradfordData is 10 elements, all with EmpNum = 10!
}

public class EmployeeRow {
    int EmpNum;
    string EmpNm; // etc.
 }