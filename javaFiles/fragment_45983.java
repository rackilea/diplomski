public class TestA extends TestParent {
    public TestA { 
        //some code here
    }

    @Override
    public File getProjectFile() {
        //some more code here
        File project = otherproject.getProjectFile();
        return project;
    }
 }