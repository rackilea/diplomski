protected String[] getSearchableDirectories()
{
     return new String[] { System.getProperty("user.home") + "/.fonts", // user
             "/usr/local/fonts", // local
             "/usr/local/share/fonts", // local shared
             "/usr/share/fonts", // system
             "/usr/X11R6/lib/X11/fonts" // X
     };
 }