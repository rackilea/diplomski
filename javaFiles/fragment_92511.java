public static void main(String[] args) throws Exception {

        Remoteserver objremoteserver=new Remoteserver();
        objremoteserver.setmsg("Hello! How are you?");
        System.out.println(objremoteserver.getmsg());
        try
        {
        Naming.rebind("Remotemethod", objremoteserver);
        System.out.println("Server Started");
        }
        catch(RemoteException re)
        {
            System.out.println(re.getLocalizedMessage());
        }
        finally
        {
            System.out.println("Unknown Exception Occured!!!!");
        }
    }