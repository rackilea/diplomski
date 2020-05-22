public class LevelSub extends LevelSup {
    protected String myName;

    public LevelSub (String myName) {
        super ("SuperClass");
        this.myName = myName;       // sets up instance variable
    }

    public void print () {
        System.out.println ("Hi, this is " + myName); // refers to this.myName
        System.out.println ("I am inherited from " + super.myName);
        System.out.println ("also known as " + defaultName); // gets from superclass
        super.print();           // overridden method of superclass
    }

    public static void main (String[] args) {
        new LevelSub("SubClass").print();
}}