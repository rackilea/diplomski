AnotherClass ac1 = new AnotherClass(10);
AnotherClass ac2 = new AnotherClass(20);

ac1.getInstanceVariable();             // Returns "10"
AnotherClass.getClassVariable();       // Returns "42"
ac2.getInstanceVariable();             // Returns "20"
AnotherClass.getClassVariable();       // Returns "42"