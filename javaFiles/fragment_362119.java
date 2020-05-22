@Component(value = "fhirService")
public class FHIRComponent {

    private static final Logger LOG = LoggerFactory.getLogger(FHIRComponent.class);

    private FHIRResourceVersionConfig fhirResourceVersionConfig;
    private List<PatientService> patientServices;//spring will inject all services

    public FHIRComponent(
        List<PatientService> patientServices,
        FHIRResourceVersionConfig fhirResourceVersionConfig) {
        this.patientServices= patientServices;
        this.fhirResourceVersionConfig = fhirResourceVersionConfig;
    }

    private Optional<PatientService> getService(String resourceType){
        return patientServices.stream()
            .filter(service => service.getCode().equalsIgnoreCase(fhirResourceVersionConfig.findResource(resourceName)))
            .findAny() 
    }

    public Object getDemographics(PatientDTO patient, String resourceType) {
        return getService(resourceType)
            .map(service => service.getDemographics(patient))
            .orElse(null);
   }
  ...