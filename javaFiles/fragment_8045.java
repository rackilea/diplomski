@Plugin(type = Command.class, menuPath = "Plugins>My New Plugin")
public class MyNewPlugin implements Command {

    @Parameter (label="Choice", choices={"Option A", "Option B"}, style="radioButtonVertical") 
    private String choice;

    // your code here
}