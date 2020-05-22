import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

//Heuristic Non-Consecutive Duplicate (NCD) Shuffler
public class NCDShuffler {

    private static Random random = new Random();
    //private static int swaps = 0;

    public static <T> void shuffle (List<T> list) {
        if (list == null || list.size() <= 1) return;
        int MAX_RETRIES = 10; //it's heuristic
        boolean found;
        int retries = 1;
        do {
            Collections.shuffle(list);
            found = true;
            for (int i = 0; i < list.size() - 1; i++) {
                T cur = list.get(i);
                T next  = list.get(i + 1);
                if (cur.equals(next)) {

                    //choose between front and back with some probability based on the size of sublists
                    int r = random.nextInt(list.size());
                    if ( i < r) {
                        if (!swapFront(i + 1, next, list, true)) {
                            found = false;
                            break;
                        }
                    } else {
                        if (!swapBack(i + 1, next, list, true)) {
                            found = false;
                            break;
                        }
                    }
                }
            }
            retries++;
        } while (retries <= MAX_RETRIES && !found);

    }

    //try to swap it with an element in a random position after it
    private static <T> boolean swapFront(int index, T t, List<T> list, boolean first) {
        if (index == list.size() - 1) return first ? swapBack(index, t, list, false) : false;
        int n = list.size() - index - 1;
        int r = random.nextInt(n) + index + 1;
        int counter = 0;
        while (counter < n) {
            T t2 = list.get(r);
            if (!t.equals(t2)) {
                Collections.swap(list, index, r);
                //swaps++;
                return true;
            }
            r++;
            if (r == list.size()) r = index + 1;
            counter++;
        }

        //can't move it front, try back
        return first ? swapBack(index, t, list, false) : false;
    }

    //try to swap it with an element in a random "previous" position
    private static <T> boolean swapBack(int index, T t, List<T> list, boolean first) {
        if (index <= 1) return first ? swapFront(index, t, list, false) : false;
        int n = index - 1;
        int r = random.nextInt(n);
        int counter = 0;
        while (counter < n) {
            T t2 = list.get(r);
            if (!t.equals(t2) && !hasEqualNeighbours(r, t, list)) {
                Collections.swap(list, index, r);
                //swaps++;
                return true;
            }
            r++;
            if (r == index) r = 0;
            counter++;
        }
        return first ? swapFront(index, t, list, false) : false;
    }

    //check if an element t can fit in position i
    public static <T> boolean hasEqualNeighbours(int i, T t, List<T> list) {
        if (list.size() == 1) 
            return false;
        else if (i == 0) {
            if (t.equals(list.get(i + 1)))
                return true;
            return false;
        } else {
            if (t.equals(list.get(i - 1)) || (t.equals(list.get(i + 1))))
                return true;
            return false;
        }
    }

    //check if shuffled with no consecutive duplicates
    public static <T> boolean isShuffledOK(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1)))
                return false;
        }
        return true;
    }
    //count consecutive duplicates, the smaller the better; We need ZERO
    public static <T> int getFitness(List<T> list) {
        int sum = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1)))
                sum++;
        }
        return sum;
    }

    //let's test it
    public static void main (String args[]) {
        HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();
        //initialise a list
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);

        /*for (int i = 0; i<100000; i++) {
            list.add(random.nextInt(10));
        }*/

        //Try to put each output in the frequency Map
        //then check if it's a uniform distribution
        Integer hash;
        for (int i = 0; i < 10000; i++) {
            //shuffle it
            shuffle(list);

            hash = hash(list);
            if (freq.containsKey(hash)) {
                freq.put(hash, freq.get(hash) + 1);
            } else {
                freq.put(hash, 1);
            }
        }
        System.out.println("Unique Outputs: " + freq.size());
        System.out.println("EntrySet: " + freq.entrySet());
        //System.out.println("Swaps: " + swaps);
        //for the last shuffle
        System.out.println("Shuffled OK: " + isShuffledOK(list));
        System.out.println("Consecutive Duplicates: " + getFitness(list));
    }

    //test hash
    public static int hash (List<Integer> list) {
        int h = 0;
        for (int i = 0; (i < list.size() && i < 9); i++) {
            h += list.get(i) * (int)Math.pow(10, i); //it's reversed, but OK
        }
        return h;
    }
}