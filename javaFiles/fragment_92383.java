public class Patient  
{
  String patientNo;
  int procedureType;
  String patientName;

  public Patient(String patientNo, String patientName, int procedureType) throws IOException
  {
     this.patientNo =  patientNo;      // variables in LHS are class members, RHS are method parameters
     this.patientName = patientName;
     this.procedureType = procedureType;
  }
}