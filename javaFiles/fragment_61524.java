private Service service;

@Inject
public OtherService(Service service) {
   this.service = service;
}