package FirstChapter;

import JustRandomPackage.*;

public class ATypeNameProgram extends YetAnotherClass{
    public ATypeNameProgram() {
        System.out.println(this.variable); // this.variable is visible
    }

    public boolean equals(ATypeNameProgram other) {
        return this.variable == other.variable; // error: YetAnotherClass.variable is not visible
    }
}