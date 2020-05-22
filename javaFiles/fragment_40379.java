@Repository
public class AdmissionRepository {

   @Autowired
   private RestTemplate restTemplate;

   public ResponseObject updateAdmission(RequestAdmission requestAdmission, String admissionId) {

   UriBuilder uriBuilder =  UriBuilder.fromUri("https://admissionportal.com").path("admission").path("admissionId="+admissionId);
   String xmlString = // create an actual valid XML string with all the <tag>value</tag> and the whole structure.
   HttpEntity<String> admissionEntity = new HttpEntity<>(xmlString, this.getHeaders);

   ResponseEntity<ResponseAdmission> responseEntity = this.restServiceESBSupport.exchange(uriBuilder.build(), HttpMethod.PATCH, admissionEntity , ResponseAdmission.class);

   return responseEntity.getBody();

}