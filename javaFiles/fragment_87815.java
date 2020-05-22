public synchronized static String getString(ContentResolver resolver, String name) {
             if (MOVED_TO_SECURE.contains(name)) {
                 Log.w(TAG, "Setting " + name + " has moved from android.provider.Settings.System"
                         + " to android.provider.Settings.Secure, returning read-only value.");
                 return Secure.getString(resolver, name);
             }
             if (sNameValueCache == null) {
                 sNameValueCache = new NameValueCache(SYS_PROP_SETTING_VERSION, CONTENT_URI,
                                                      CALL_METHOD_GET_SYSTEM);
             }
             return sNameValueCache.getString(resolver, name);
         }