@RestController
public class mainController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() throws IOException, GeneralSecurityException {
    DriveQuickstart drive = new DriveQuickstart("c:/temp/credentials.json");
    String res = drive.checkFile("cwg");

    return res;
}