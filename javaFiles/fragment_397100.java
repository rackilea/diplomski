// Native Code
int socket;

JNIEXPORT jint JNICALL
Java_com_my_package_Class_initializeSocket
(
    JNIEnv *env,
    jobject jobj
) {
    socket = socket(AF_INET, SOCK_DGRAM, 0);

    // . . . Handler other socket preparations 

    return (jint)socket;
}