public synchronized static String getString(ContentResolver resolver, String name) {
            if (sNameValueCache == null) {
                sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI,
                                                     CALL_METHOD_GET_SECURE);
            }

            if (sLockSettings == null) {
                sLockSettings = ILockSettings.Stub.asInterface(
                        (IBinder) ServiceManager.getService("lock_settings"));
                sIsSystemProcess = Process.myUid() == Process.SYSTEM_UID;
            }
            if (sLockSettings != null && !sIsSystemProcess
                    && MOVED_TO_LOCK_SETTINGS.contains(name)) {
                try {
                    return sLockSettings.getString(name, "0", UserId.getCallingUserId());
                } catch (RemoteException re) {
                    // Fall through
                }
            }

            return sNameValueCache.getString(resolver, name);
        }