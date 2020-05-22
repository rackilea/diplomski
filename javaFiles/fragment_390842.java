package registry;

import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.sun.jna.platform.win32.Advapi32Util;
import com.sun.jna.platform.win32.Win32Exception;

public class FriendlyName {

    private static final String ENUM = "SYSTEM\\CurrentControlSet\\Enum\\USB";
    private Map<String, String> friendlyNames;
    private static final String KEY = "HARDWARE\\DEVICEMAP\\SERIALCOMM";

    public FriendlyName() {
        friendlyNames = new HashMap<>();

        Pattern p = Pattern.compile(".*?\\(([^)]+)\\)");
        for (String dev : Advapi32Util.registryGetKeys(HKEY_LOCAL_MACHINE, ENUM)) {
            String sb = ENUM + "\\" + dev;
            for (String itm : Advapi32Util.registryGetKeys(HKEY_LOCAL_MACHINE, sb)) {
                String si = sb + "\\" + itm;
                String fn = null;
                try {
                    fn = Advapi32Util.registryGetStringValue(HKEY_LOCAL_MACHINE, si, "FriendlyName");
                } catch (Win32Exception e) {}
                if (fn != null) {
                    Matcher m = p.matcher(fn);
                    if (m.matches()) {
                        friendlyNames.put(m.group(1), fn);
                    }
                }
            }
        }
    }

    String get(String key) {
        return friendlyNames.get(key);
    }

    public String getCOM(String name) {
        try {
            for (Entry<String, Object> sub : Advapi32Util.registryGetValues(HKEY_LOCAL_MACHINE, KEY).entrySet()) {
                String n = (String) sub.getValue();
                String fn = get(n);
                if (fn != null && fn.startsWith(name))
                    return n;
            }
        } catch (IllegalArgumentException e) {
            System.err.println(e);
        }
        return null;
    }

    public static void main(String[] args) {
        FriendlyName fn = new FriendlyName();
        System.out.println(fn.getCOM(args[0]));
    }

}