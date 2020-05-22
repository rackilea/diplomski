$ javac Test.java
$ rm Address.class
$ java Test
Person successfully instantiated with name John Doe
Exception in thread "main" java.lang.NoClassDefFoundError: LAddress;
        at java.lang.Class.getDeclaredFields0(Native Method)
        at java.lang.Class.privateGetDeclaredFields(Class.java:2308)
        at java.lang.Class.getDeclaredField(Class.java:1897)
        at java.io.ObjectStreamClass.getDeclaredSUID(ObjectStreamClass.java:1624)
        at java.io.ObjectStreamClass.access$700(ObjectStreamClass.java:69)
        at java.io.ObjectStreamClass$2.run(ObjectStreamClass.java:442)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.io.ObjectStreamClass.<init>(ObjectStreamClass.java:430)
        at java.io.ObjectStreamClass.lookup(ObjectStreamClass.java:327)
        at java.io.ObjectOutputStream.writeObject0(ObjectOutputStream.java:1130)
        at java.io.ObjectOutputStream.writeObject(ObjectOutputStream.java:346)
        at Test.main(Test.java:10)
Caused by: java.lang.ClassNotFoundException: Address
        at java.net.URLClassLoader$1.run(URLClassLoader.java:217)
        at java.security.AccessController.doPrivileged(Native Method)
        at java.net.URLClassLoader.findClass(URLClassLoader.java:205)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:321)
        at sun.misc.Launcher$AppClassLoader.loadClass(Launcher.java:294)
        at java.lang.ClassLoader.loadClass(ClassLoader.java:266)
        ... 12 more