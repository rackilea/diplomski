import java.io.File; 

 import org.eclipse.swt.browser.Browser; import org.eclipse.swt.browser.BrowserFunction;

 public class ListFilesFunction extends BrowserFunction {

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


 " does not exist');");

     if (!file.isDirectory())
        browser.execute("alert('Path " + args[0] + " must be a folder');");

    return file.list();
}


 }