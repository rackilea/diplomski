package com.one

public class Test {
    // not implementable outside of current package
    interface NestedDefaultInterface {

    }

    // implementable in child classes outside of package
    protected interface NestedProtectedIface {

    }
}