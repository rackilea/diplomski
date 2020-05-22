public static boolean checkDelete(String fileName)
{
    SecurityManager manager = System.getSecurityManager(); //instead of new SecurityManager();
    try{
        if (manager != null)
            manager.checkDelete(destination+fileName);
    }
    catch(SecurityException e){
        e.printStackTrace();
        return false;
    }
    return true;
}