for (SuperClass superClass: list) {
    if (superClass instanceof SubClass1) {
        SubClass1 subClass = (SubClass1) superClass;
    }
    else if (superClass instanceof SubClass2) {
        SubClass2 subClass = (SubClass2) superClass;
    }
    else {
        // Something strange has happened, or superClass is null
    }
}