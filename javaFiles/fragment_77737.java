import java.util.Arrays;

public class Main
{
    static class Actor {}
    static class Frog extends Actor {@Override public String toString() {return "I'm a frog";}}
    static class Lizard extends Actor {@Override public String toString() {return "I'm a lizard";}}

        private static Actor[] actors;        

        public static Actor[] getActors(Class<?> cls) {
            //Count actors corresponding to class cls
            int cnt = 0;      
            for (int i = 0; i<actors.length; i++)
               if (cls.isInstance(actors[i])) cnt++; 

            //Build a new array;
            Actor[] clsActors = new Actor[cnt];

            //Fill it
            for (int j = 0, k=0; j<cnt; k++)
                    if (cls.isInstance(actors[k]))
                  clsActors[j++] = actors[k];

            return clsActors;
        }

    public static void main(String[] args)
    {
            actors = new Actor[] {new Frog(), new Lizard()};
            System.out.println(Arrays.toString(getActors(Frog.class)));
    }
}