UIDefaults uiDefaults = UIManager.getDefaults();
Enumeration enum = uiDefaults.keys();
while (enum.hasMoreElements())
{
    Object key = enum.nextElement();
    Object val = uiDefaults.get(key);
    System.out.println("[" + key.toString() + "]:[" +
        (null != val ? val.toString() : "(null)") +
        "]");
}