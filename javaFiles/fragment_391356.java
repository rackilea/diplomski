Browser browser = null;
String functionName = null;

public ListFilesFunction(Browser browser, String name) {
    super(browser, name);
    this.browser = browser;
    this.functionName = name;
}

public Object function (Object[] args)
{
    if (args.length == 0)
        browser.execute("alert('Function " + 
        functionName + " requires one argument - parent folder path');");

    File file = new File(args[0].toString());

    if (!file.exists())
        browser.execute("alert('Folder " + args[0] +