public class ExampleClass{

private static Browser browser;

public DriverContainer(Browser brows){
    browser = brows;
}

public static Browser getBrowser() {
    return browser;
}