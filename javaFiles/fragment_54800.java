@SpringBootApplication
@Controller
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class);
  }


  @RequestMapping(value = "/testing", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  private void testing(@RequestBody Request body, @RequestHeader HttpHeaders headers, HttpServletRequest httpRequest) {
    System.out.println(body.getTest());
  }
}