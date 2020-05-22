interface HasXYZ {
    void setXYZ(XYZType xyz);
    XYZType getXYZ();
}

class SomeClass implements HasXYZ {
    // ...
}

class AnotherClass implements HasXYZ {
    // ...
}

class AndAnotherClass implements HasXYZ {
    // ...
}