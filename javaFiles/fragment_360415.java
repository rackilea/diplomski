package example.primenumbers;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {

    private Client() {}

    public static void main(final String[] args) {
        final long startTime = System.nanoTime();

        final int n;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the value of n:");
            n = scanner.nextInt();
        }
        final String host = (args.length < 1) ? null : args[0];
        try {
            final Registry registry = LocateRegistry.getRegistry(host);
            final PrimeNumber stub = (PrimeNumber) registry.lookup("PrimeNumber");
            final String response = stub.sayPrimeNumber(n);

            System.out.println(response);
            final long endTime = System.nanoTime();
            final long duration = (endTime - startTime)/1000000000;
            System.out.println("Took: " + duration);
        } catch (final RemoteException | NotBoundException e) {
            System.err.println("Client exception: " + e);
            e.printStackTrace();
        }
    }
}