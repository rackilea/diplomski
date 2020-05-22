package com.two

class SubTest extends Test { 
    public void testProtected() {
        NestedProtectedIface npi = new NestedProtectedIface () {
           // implementation
        };
    }

    public void testDefault() {
        // Won't compile!
    //    NestedDefaultInterface ndi = new NestedDefaultInterface() {
    //    };
    }
}