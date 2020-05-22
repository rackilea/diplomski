vonLoad = dlsym(handle, "JNI_OnLoad");
    if (vonLoad == NULL) {
        LOGD("No JNI_OnLoad found in %s %p\n", pathName, classLoader);
    } else {
        /*
         * Call JNI_OnLoad.  We have to override the current class
         * loader, which will always be "null" since the stuff at the
         * top of the stack is around Runtime.loadLibrary().  (See
         * the comments in the JNI FindClass function.)
         */
        OnLoadFunc func = vonLoad;
        Object* prevOverride = self->classLoaderOverride;

        self->classLoaderOverride = classLoader;
        oldStatus = dvmChangeStatus(self, THREAD_NATIVE);
        LOGV("+++ calling JNI_OnLoad(%s)\n", pathName);
        version = (*func)(gDvm.vmList, NULL);
        dvmChangeStatus(self, oldStatus);
        self->classLoaderOverride = prevOverride;