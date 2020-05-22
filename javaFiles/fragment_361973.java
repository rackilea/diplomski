@RunWith(SpringJUnit4ClassRunner.class)
public class ContractorFormValidatorTest {

  @Autowired
  private ContractorFormValidator validator;

  @Test
  public void testValidation() throws Exception {
    Contractor contractor = new Contractor();
    // Initialise the variables here.

    Errors errors = new BeanPropertyBindingResult(contractor, "contractor");
    validator.validate(contract, errors);

    // If errors are expected.
    Assert.assertTrue(errors.hasErrors());

   for (Error fieldError : errors.getFieldErrors()) {
       Assert.assertEquals("contractorData.nip", fieldError.getCode());
   }
  }
}