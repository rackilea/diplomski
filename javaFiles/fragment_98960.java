public class EmailValidationTest{
     private @InjectsMock EmailValidation validation; 
     private String emailRegexPattern = "^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$";

     @BeforeAll
     public void setUp(){
        ReflectionTestUtils.setField(validation, "emailRegex", emailRegexPattern);
     }

    //your test cases over here.
    }