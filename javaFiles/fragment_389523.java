@RestController
@RequestMapping("/customer")
public class CustomerController {

    private static final Set<String> ignorableFieldNames= new HashSet<>();

    static {
        ignorableFieldNames.add("customerId");
    }

    @RequestMapping("auto")
    public Customer getAuto() throws JsonProcessingException {
        return new Customer("123", "456");
    }

    @RequestMapping("manual")
    public String getManual() throws JsonProcessingException {
        SimpleFilterProvider simpleFilterProvider = new SimpleFilterProvider().setFailOnUnknownId(false);
        FilterProvider filters = simpleFilterProvider.addFilter("customerFilter", SimpleBeanPropertyFilter.serializeAllExcept(ignorableFieldNames));

        ObjectWriter writer = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.setFilterProvider(filters);
        writer = mapper.writer();

        Customer customer = new Customer("123", "456");
        String dtoAsString = writer.writeValueAsString(customer);
        return dtoAsString;
    }
}