JNIEXPORT jint JNICALL Java_something_doOwnPort(JNIEnv *env, jobject object, jint port) {
    long totalFDs = getdtablesize();
    struct sockaddr_in sa;
    struct stat sb;
    // Iterate through all file descriptors
    for (int i = 0; i < totalFDs; ++i) {
        // Check if "i" is a valid FD
        memset(&sb, 0, sizeof(sb));
        if (fstat(i, &sb) < 0)
            continue;
        // Check if "i" is a socket
        if (!S_ISSOCK(sb.st_mode))
            continue;
        // Get local address of socket with FD "i"
        memset(&sa, 0, sizeof(sa));
        socklen_t sa_len = sizeof(sa);
        getsockname(i, (struct sockaddr*) &sa, &sa_len);
        // Check if the port matches
        if (sa.sin_port == port)
            return 1; // We own the port
    }
    return -1; // We don't own the port
}