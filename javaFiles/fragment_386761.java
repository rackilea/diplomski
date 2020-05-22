public static void setUIFont(javax.swing.plaf.FontUIResource f)
{   
    java.util.Enumeration keys = UIManager.getDefaults().keys();
    while(keys.hasMoreElements())
    {
        Object key = keys.nextElement();
        Object value = UIManager.get(key);
        if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
    }
}

// ...

try
{
    setUIFont(new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN,12));
}
catch(Exception e){}