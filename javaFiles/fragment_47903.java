import java.util.ArrayList;

public class Test
{
    public static void main(String[] args) {
        String[] boys={"shivam","shubham","sagar","Tushar","tarun"};  String[]girls={"payal","preeti","neetika","sakshi_jain","sakshi_singh","wafa","Reshu","Pragya"};
        String[] feelings={"Love","Hate","Adore","want_to_kill"};

        int x=boys.length;
        int y=girls.length;
        int z=feelings.length;

        for(int i=0;i<10;i++)
        {
            int rand1=(int)(Math.random()*x);
            int rand2=(int)(Math.random()*y);
            int rand3=(int)(Math.random()*z);

            String phase1=girls[rand2]+" "+feelings[rand3]+" "+boys[rand1];
            String phase2=boys[rand1]+" "+feelings[rand3]+" "+girls[rand2];

            ArrayList<Phase> phase = new ArrayList<>();
            phase.add(new Phase(phase1, phase2));

            int p=phase.size();
            int q=(int)(Math.random()*p);

            System.out.println(phase.get(q));
            System.out.println("**************");
        }
    }
}

class Phase {
    String phase1;
    String phase2;

    public Phase(String p1, String p2) {
        this.phase1 = p1;
        this.phase2 = p2;
    }
    public String toString(){
        return phase1 + "\n" + phase2;
    }
}