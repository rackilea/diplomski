package package1;

public class Package1Class {
}

package package2;

import package1.Package1Class;

public class Package2Class {
    private Package1Class x;

    public Package2Class (Package1Class x) {
        this.x = x
    }
}