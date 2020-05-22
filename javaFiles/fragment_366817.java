@Override
public boolean equals(Object other) {
    System.out.println("TestClass.equals() was called");

    if (this == other) return true ;

    // cue endless arguments about whether to use instanceof or getClass()...
    if (! (other instanceof TestClass)) return false ;

    TestClass tc = (TestClass) other ;
    return this.id == tc.id && Objects.equals(this.name, tc.name); 
}