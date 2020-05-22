AnotherClass ac1 = new AnotherClass(10);
AnotherClass ac2 = new AnotherClass(20);

ac1.getInstanceVariable();             // Returns "10"
ac1.getClassVariableFromInstance();    // Returns "42"
ac2.getInstanceVariable();             // Returns "20"
ac2.getClassVariableFromInstance();    // Returns "42"