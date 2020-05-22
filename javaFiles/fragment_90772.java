boolean isApp = false;
boolean isEnv = false;

for (int i = 0; i<args.length; i++) {
    if (args[i].equals ("-app")) {
        isApp = true;
        isEnv = false;
    } else if (args[i].equals ("-env")) {
        isEnv = true;
        isApp = false;
    } else if (isEnv) {
        envList.add(args[i]);
    } else if (isApp) {
        appList.add(args[i]);
    }
}