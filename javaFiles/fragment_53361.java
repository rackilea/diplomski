@Configuration
class Config {

   @Bean
   Map<String, Tool> tools(Hammer hammer) {
     Map<String, Tool> map = new HashMap<>();
     map.put("hammer", hammer);
     //map.put("hammer",new Hammer())
     return Collections.unmodifiableMap(map);
   }

}


@Component
public class Container {

    private Map<String, Tool> tools;

    @Autowired
    public Container(Map<String, Tool> tools) {
        this.tools = tools;
    }

    Tool getTool(String tool) {
        return tools.get(tool);
    }
}