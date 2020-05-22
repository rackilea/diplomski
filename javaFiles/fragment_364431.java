@RunWith(SpringRunner.class)
    @SpringBootTest
    @AutoConfigureMockMvc
    public class AdditiveControllerShould {

     @Autowired
      private MockMvc mockMvc;

     private static final ObjectMapper mapper=new ObjectMapper();

     @Test
      public void saveAnEntryWhenPOSTOnlyUserIdAndContactName() throws Exception {
         Map<String,String> phones=new HashMap<>();
         phones.put("phone1", "12345");
         Map<String,Object> input=new HashMap<>();
         input.put("userId", "123456");
         input.put("contactName", "TEST");
         input.put("phones", phones);
         mockMvc.perform(post("/newContact")
               .content(mapper.writeValueAsString(input))
               .contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))           
                .andExpect(status().isOk());

      }

}