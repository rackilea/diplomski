public class AppUserDeserializer extends JsonDeserializer implements Serializable {

    private AppUserService appUserService;

    public AppUserDeserializer() {
      // Set appUserService to the instance created by spring
      this.appUserService = AppUserService.instance;
    }

    ...

}