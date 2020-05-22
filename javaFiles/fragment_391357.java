public class View extends ViewPart
{
    Browser browserCtl = null;
    ... 

 public void createPartControl(Composite parent) {
    ...
    browserCtl = new Browser(parent, SWT.None);

    new ListFilesFunction(browserCtl, "getFiles");
    ...
}
...


 }