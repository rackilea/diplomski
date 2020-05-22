public interface FHIRPatientService {

   String getCode();

   Object getDemographics(PatientDTO patient);

   Object getProcedures(PatientDTO patient);
}