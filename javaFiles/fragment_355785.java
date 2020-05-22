public void exit() throws RemoteException
{
    try{
        // Unregister ourself
        Naming.unbind(mServerName);

        // Unexport; this will also remove us from the RMI runtime
        UnicastRemoteObject.unexportObject(this, true);

        System.out.println("CalculatorServer exiting.");
    }
    catch(Exception e){}
}