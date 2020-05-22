$ mkdir jnitest
$ cd jnitest
$ mkdir AndroidTest
$ mkdir AndroidTest/AccelerometerTest
$ vim AndroidTest/AccelerometerTest/NativeCaller.java
    [pasted your code into the file, fixing two typos]
    [missing ';' and loadLibrary starting with lower-case 'l']
    [saved the file and exited editor]
$ javac AndroidTest/AccelerometerTest/NativeCaller.java
$ javah -jni AndroidTest.AccelerometerTest.NativeCaller
$ ls
AndroidTest                                  AndroidTest_AccelerometerTest_NativeCaller.h