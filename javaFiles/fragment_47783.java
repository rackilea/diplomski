if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
        //Not sure if this part works haven't tested it yet
        CookieSyncManager sm = CookieSyncManager.createInstance(context);
        sm.sync();
    } else {
        cookies.flush();
    }