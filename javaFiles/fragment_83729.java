Stack: [0x0000000002500000,0x0000000002600000],  sp=0x00000000025ff4e0,  free space=1021k
Native frames: (J=compiled Java code, j=interpreted, Vv=VM code, C=native code)
V  [jvm.dll+0x14ebb6]
C  [TestNativeArray3D.dll+0x397d]  JNIEnv_::NewObjectArray+0x4d
C  [TestNativeArray3D.dll+0x3ae8]  Java_TestNativeArray3D_genTerrain+0x98
C  0x0000000002715534

Java frames: (J=compiled Java code, j=interpreted, Vv=VM code)
j  TestNativeArray3D.genTerrain(III)[[[I+0
j  TestNativeArray3D.main([Ljava/lang/String;)V+11
v  ~StubRoutines::call_stub