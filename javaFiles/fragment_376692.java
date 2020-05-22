int pid = 0;
if(p.getClass().getName().equals("java.lang.UNIXProcess")) {
    /* get the PID on unix/linux systems */
    try {
        Field f = p.getClass().getDeclaredField("pid");
        f.setAccessible(true);
        pid = f.getInt(p);
    }
    catch (Throwable e) {
    }
}  
System.out.println("Child Complete : " + pid);