import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Given a registry key, attempts to get the 'FriendlyName' value
// Returns null on failure.
//
public static String getFriendlyName(String registryKey) {
    if (registryKey == null || registryKey.isEmpty()) {
        throw new IllegalArgumentException("'registryKey' null or empty");
    }
    try {
        int hkey = WinRegistry.HKEY_LOCAL_MACHINE;
        return WinRegistry.readString(hkey, registryKey, "FriendlyName");
    } catch (Exception ex) { // catch-all: 
        // readString() throws IllegalArg, IllegalAccess, InvocationTarget
        System.err.println(ex.getMessage());
        return null;
    }
}

// Given a registry key, attempts to parse out the integer after
// substring "COM" in the 'FriendlyName' value; returns -1 on failure.
//
public static int getComNumber(String registryKey) {
    String friendlyName = getFriendlyName(registryKey);

    if (friendlyName != null && friendlyName.indexOf("COM") >= 0) {
        String substr = friendlyName.substring(friendlyName.indexOf("COM"));
        Matcher matchInt = Pattern.compile("\\d+").matcher(substr);
        if (matchInt.find()) {
            return Integer.parseInt(matchInt.group());
        }
    }
    return -1;
}