public class EnumTest {

    public enum State{
        START_STATE("1"),INTER_STATE("2"),END_STATE("3");

        String name;
        State(String name){this.name = name;}
        String getName() {return name;}
    }

    public static void main(String[] args) {
        for(State state : EnumTest.State.values())
            System.out.println(state.getName());
    }
}