public class Patient
{
 static String patientNo;
 static int procedureType;
 static String patientName;

 public Patient(String ptNo, String ptName, int procType) throws IOException
 {
     Patient.patientNo =  ptNo;
     Patient.patientName = ptName;
     Patient.procedureType = procType;
 }
}