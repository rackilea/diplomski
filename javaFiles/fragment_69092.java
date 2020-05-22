package package1;

public class Package1Class {
}

package package2;

public class Package2Class {
    //look that there is not use of the import statement, however everytime you need
    //to call Package1Class, you should provide the full package name
    private package1.Package1Class x;

    public Package2Class (package1.Package1Class x) {
        this.x = x
    }
}