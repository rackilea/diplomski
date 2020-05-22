StringReference safeStringRef(VirtualMachine vm, String string) {
    ObjectCollectedException lastCause = null;
    for (int numTries = 0; numTries < SANE_TRY_LIMIT; ++numTries) {
        StringReference stringRef = vm.mirrorOf(string);
        try {
            stringRef.disableCollection();
            return stringRef;
        } catch (ObjectCollectedException e) {
            lastCause = e;
        }
    }
    throw new RuntimeException("Can't create safe string reference", lastCause);
}