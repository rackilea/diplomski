import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LifeGig {

    public static class Performer {
        int arrival, duration;

        Performer(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }

        @Override
        public String toString() {
            return "Performer [arrival=" + arrival + ", duration=" + duration + "]";
        }
    }

    public List<Performer> program(int[] entry,int[] duration)
    {
        List<Performer> performers=new ArrayList<>();
        for(int i=0;i<entry.length;i++)
        {
            performers.add(new Performer(entry[i],duration[i]));
        }
        Collections.sort(performers, new Comparator<Performer>() {
            @Override
            public int compare(Performer p1, Performer p2) {
                return Integer.compare(p1.arrival+p1.duration, p2.arrival+p2.duration);
            }
        });
        List<Performer> festival=new ArrayList<>();
        System.out.println(performers);
        int currentTime = 1;
        for (Performer p:performers) {
            if (p.arrival >= currentTime) {
                currentTime = p.arrival+p.duration;
                festival.add(p);
            }
        }
        return festival;
    }
    public static void test1()
    {
        int[] entry = new int[] {1,3,3,5,7};
        int[] duration = new int[] {2,2,1,2,1};
        List<Performer> festival=new LifeGig().program(entry,duration);
        System.out.println("Count (Expected=4): " + festival.size());
        System.out.println("lineup:"+festival);
    }

    public static void test2()
    {
        int[] entry = new int[] {1, 1, 1, 1, 4};
        int[] duration = new int[] {10, 3, 6, 4, 2};
        List<Performer> festival=new LifeGig().program(entry,duration);
        System.out.println("Count (Expected=2): " + festival.size());
        System.out.println("lineup:"+festival);
    }
    public static void test3()
    {
        int[] entry = new int[] {1,2,3,4};
        int[] duration = new int[] {10, 1,1,1,};
        List<Performer> festival=new LifeGig().program(entry,duration);
        System.out.println("Count (Expected=3): " + festival.size());
        System.out.println("lineup:"+festival);

    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

}