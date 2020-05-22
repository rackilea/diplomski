import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Contest {

static Random rand = new Random();

static class Pairing {
    int contestantA;
    int contestantB;
    public Pairing(int a, int b) {
        contestantA = a;
        contestantB = b;
    }
    public String toString() {
        return ""+contestantA+" - "+contestantB;
    }
}

static int countBackToBacks(List<Pairing> pairs) {
    int backs = 0;
    for(int x=0;x<pairs.size()-1;++x) {
        Pairing a = pairs.get(x);
        Pairing b = pairs.get(x+1);
        if(a.contestantA==b.contestantA || a.contestantA==b.contestantB || 
                a.contestantB==b.contestantA || a.contestantB==b.contestantB)
        {
            ++backs;                
        }
    }           

    return backs;
}

static void randomize(List<Pairing> pairs) {
    int a = rand.nextInt(pairs.size());
    int b = rand.nextInt(pairs.size());
    Pairing pa = pairs.get(a);
    Pairing pb = pairs.get(b);
    pairs.set(a, pb);
    pairs.set(b, pa);       
}

public static void main(String [] args) {

    List<Pairing> pairs = new ArrayList<Pairing>();
    int numEntries = 5;//Integer.parseInt(args[0]);
    for(int x=0;x<numEntries-1;++x) {
        for(int y=x+1;y<numEntries;++y) {               
            Pairing p = new Pairing(x+1,y+1);
            pairs.add(p);               
        }
    }

    int bestVal = Integer.MAX_VALUE;
    String best = "";
    for(int x=0;x<1000000;++x) {
        randomize(pairs);
        int backs = countBackToBacks(pairs);
        if(backs<bestVal) {
            bestVal = backs;
            best = pairs.toString();
        }
    }

    System.out.println(best + bestVal);

}   

}