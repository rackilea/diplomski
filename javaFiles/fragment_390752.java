package testAction;

@ParentPackage("json-default")
@Namespace("/")
@Action(value="hello1", results=@Result(name = "success", location="TestPage.jsp"))
public class Hello1Action extends ActionSupport {
}