@RestController
@RequestMapping("/test")
public class TestRest {

  @RequestMapping(method = RequestMethod.GET)
  public List<TestDTO> get() {
    List<TestDTO> dtos = new ArrayList<>();
    dtos.add(new TestDTO("value1","value2"));
    dtos.add(new TestDTO("value1","value2"));
    return dtos;
  }
}