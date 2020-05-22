public class LevelSup {
    // cannot be private if accessed by subclass
    protected String myName, defaultName = "TopLevel";

    public LevelSup (String name) {
        myName = name;      // this not required, no name clash
    }

    // cannot be private if accessed by subclass
    public void print () {
        System.out.println ("Hi, this is " + myName);
    }
}