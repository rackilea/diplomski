public class MyAction implements IObjectActionDelegate {

private IFolder selectedFolder;
private IPath path;

@Override
public void run(IAction action) {
    String flagValue = foo();
    String projectLocation = bar();

    MyJob runTestCaseJob = new MyJob(flagValue , projectLocation);
        runTestCaseJob.schedule();
}