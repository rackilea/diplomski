public class Payload {
    int key,b,c;
    Payload(int _key) { key = _key; }
}


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class Overhead {
    @Test
    public void useHashMap()
    {
        int i=0;
        try {
            Map<Integer, Payload> map = new HashMap<Integer, Payload>();
            for (i=0; i < 4000000; i++) {
                int key = (int)(Math.random() * Integer.MAX_VALUE);
                map.put(key, new Payload(key));
            }
        }
        catch (OutOfMemoryError e) {
            System.out.println("Got up to: " + i);
        }
    }

    @Test
    public void useArrayList()
    {
        int i=0;
        try {
            ArrayListMap map = new ArrayListMap();
            for (i=0; i < 9000000; i++) {
                int key = (int)(Math.random() * Integer.MAX_VALUE);
                map.put(key, new Payload(key));
            }
        }
        catch (OutOfMemoryError e) {
            System.out.println("Got up to: " + i);
        }
    }
}


import java.util.ArrayList;


public class ArrayListMap {
    private ArrayList<Payload> map = new ArrayList<Payload>();
    private int[] primes = new int[128];

    static boolean isPrime(int n)
    {
        for (int i=(int)Math.sqrt(n); i >= 2; i--) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    ArrayListMap()
    {
        for (int i=0; i < 11000000; i++)    // this is clumsy, I admit
            map.add(null);
        int n=31;
        for (int i=0; i < 128; i++) {
            while (! isPrime(n))
                n+=2;
            primes[i] = n;
            n += 2;
        }
        System.out.println("Capacity = " + map.size());
    }

    public void put(int key, Payload value)
    {
        int hash = key % map.size();
        int hash2 = primes[key % primes.length];
        if (hash < 0)
            hash += map.size();
        do {
            if (map.get(hash) == null) {
                map.set(hash, value);
                return;
            }
            hash += hash2;
            if (hash >= map.size())
                hash -= map.size();
        } while (true);
    }

    public Payload get(int key)
    {
        int hash = key % map.size();
        int hash2 = primes[key % primes.length];
        if (hash < 0)
            hash += map.size();
        do {
            Payload payload = map.get(hash);
            if (payload == null)
                return null;
            if (payload.key == key)
                return payload;
            hash += hash2;
            if (hash >= map.size())
                hash -= map.size();
        } while (true);
    }
}