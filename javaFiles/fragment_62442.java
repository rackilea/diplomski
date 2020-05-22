jobjectRefType GetObjectRefType(JNIEnv* env, jobject obj);

The function GetObjectRefType returns one of the following enumerated values defined as a jobjectRefType:

JNIInvalidRefType = 0,
JNILocalRefType = 1,
JNIGlobalRefType = 2,
JNIWeakGlobalRefType = 3