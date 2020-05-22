public class MainController{
@Before
public static void check(){
  // checking, if not fulfilled - render error and requested method is not invoked.
  renderText("Error");
}
public static void someMethod() {/*some action*/}
public static void otherMethod() {/*...other action*/}