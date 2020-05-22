@ContextConfiguration("classpath:cucumber.xml")
public class CucumberStepDefs {

    @Autowired
    SpringDAO dao;

    @Autowired
    SpringService service;
}