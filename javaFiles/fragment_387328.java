@ContextConfiguration(locations = {"classpath:/com/abc/def/configuration1.xml"})
public class StepsAndConfig1 {
    @Then("^some useful step$")
    public void someStep(){
        int a = 0;
    }
}