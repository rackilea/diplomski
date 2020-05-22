package example.primenumbers;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server implements PrimeNumber{

    public Server() {}

    public String sayPrimeNumber(final int n) throws RemoteException {

        String  primeNumbers = "";
        for (int i = 1; i <= n; i++)
        {
            int counter=0;
            for(int num = i; num>=1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                //Appended the Prime number to the String
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to n are :");
        System.out.println(primeNumbers);
        return primeNumbers;
    }

    public static void main(final String[] args) {
        try {
            final Server obj = new Server();
            final PrimeNumber stub = (PrimeNumber) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            final Registry registry = LocateRegistry.getRegistry();
            registry.bind("PrimeNumber", stub);

            System.err.println("Server ready");
        } catch (final Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}