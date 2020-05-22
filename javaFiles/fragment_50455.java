import com.fasterxml.jackson.databind.ObjectMapper;

/*snip*/

@Controller
public class MyController{

    //I prefer to have a single instance of the mapper and then inject it using Spring autowiring
    private ObjectMapper mapper;

    @Autowired
    public MyController(ObjectMapper objectMapper){

        this.objectMapper = objectMapper;
    }

    @RequestMapping(value="/myapp/MyAction", method= {RequestMethod.POST})
    public void myAction(@RequestParam(value = "person") String json, 
                         HttpServletResponse response) throws IOException {

        Person pojo = objectMapper.readValue(new StringReader(json), Person.class);

        int age = pojo.getAge();
        age++;
        pojo.setAge(age);

        objectMapper.writeValue(response.getOutputStream(),pojo);
    }
}