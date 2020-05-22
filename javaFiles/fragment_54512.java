import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class DualRobot {

    public enum Orientation{
        E(1, 0), S(0, 1), O(-1, 0), N(0, -1);

        public final int dx, dy;
        private Orientation(int dx, int dy){
            this.dx = dx;
            this.dy = dy;
        }

        public Orientation left(){
            return Orientation.values()[(this.ordinal() + 3) % 4];
        }

        public Orientation right(){
            return Orientation.values()[(this.ordinal() + 1) % 4];
        }

        public static Orientation valueOf(char c){
            for(Orientation o : Orientation.values()){
                if(o.toString().equalsIgnoreCase("" + c)) return o;
            }
            return null;
        }

    }

    public enum Action {FORWARD, COUNTER_CLOCKWISE, CLOCKWISE}; // F: forward, L: Counter clockwise, R: clockwise

    private static class Robot{
        Point position;
        Orientation orientation;

        public Robot(Robot r){
            this.position = new Point(r.position);
            this.orientation = r.orientation;
        }
        public Robot(int x, int y, Orientation orientation){
            this.position = new Point(x, y);
            this.orientation = orientation;
        }

        public void move(Action action, char[][] map){
            switch (action) {
            case FORWARD:
                Point nextPosition = new Point(position);
                nextPosition.translate(orientation.dx, orientation.dy);
                if(isValidPosition(nextPosition, map)) position = nextPosition;
                break;
            case COUNTER_CLOCKWISE:
                this.orientation = this.orientation.left();
                break;
            case CLOCKWISE:
                this.orientation = this.orientation.right();
                break;
            }
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Robot) {
                Robot r = (Robot) obj;
                return r.position.equals(this.position) && r.orientation == this.orientation;
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            return orientation.ordinal() + position.x * 10 + position.y * 1000;
        }

        private boolean isValidPosition(Point p, char[][] map){
            return p.x >= 0 && p.x < map[0].length 
                && p.y >= 0 && p.y < map.length
                && map[p.y][p.x] != '*';
        }
    }

    private static class State{
        private Robot a, b;
        private int counter;

        public State(Robot a, Robot b, int counter) {
            this.a = new Robot(a);
            this.b = new Robot(b);
            this.counter = counter;
        }

        public List<State> nextStates(char[][] map){
            List<State> states = new ArrayList<State>();
            for(Action action : Action.values()){
                State s = new State(this.a, this.b, this.counter + 1);
                s.a.move(action, map);
                s.b.move(action, map);
                if(!s.a.position.equals(s.b.position)){ // Test for collision
                    states.add(s);
                }
            }
            return states;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State state = (State) obj; // Consider the state to be the same if the 2 robots are at identical location and orientation
                return (this.a.equals(state.a) && this.b.equals(state.b))
                    || (this.a.equals(state.b) && this.b.equals(state.a));
            }
            return super.equals(obj);
        }

        @Override
        public int hashCode() {
            // The quality of this hashCode can affect the program's speed
            // Multiply is transitive, so if you swap a and b, the hashcode is the same
            return a.hashCode() * b.hashCode();
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("input.txt"));
        int size;

        while((size = Integer.parseInt(input.readLine())) > 0){
            // Load the data;
            char[][] map = new char[size][size];
            for (int i = 0; i < size; i++) {
                map[i] = input.readLine().toCharArray();
            }

            // Construct initial state
            List<Robot> robots = new ArrayList<Robot>();
            List<Point> destinations = new ArrayList<Point>();
            for(int i = 0; i < size; i ++){
                for(int j = 0; j < size; j ++){
                    Orientation orientation = Orientation.valueOf(map[i][j]);
                    if(orientation != null){
                        robots.add(new Robot(j, i, orientation));
                    }else if(map[i][j] == 'D'){
                        destinations.add(new Point(j, i));
                    }
                }
            }

            System.out.println(BFSSearch(map, new State(robots.get(0), robots.get(1), 0), destinations));

        }

    }

    private static int BFSSearch(char[][] map, State initialState, List<Point> destinations) throws IOException{
        List<State> queue = new LinkedList<State>(); // Array list is slightly more efficient
        queue.add(initialState); // Initial state
        Map<State, Boolean> testedStates = new HashMap<State, Boolean>();
        while(queue.size() > 0){
            State currentState = queue.remove(0);
            if(testedStates.containsKey(currentState)) continue;

            // Testing for end condition
            if((currentState.a.position.equals(destinations.get(0)) && currentState.b.position.equals(destinations.get(1)))
            || (currentState.a.position.equals(destinations.get(1)) && currentState.b.position.equals(destinations.get(0)))){
                return currentState.counter;
            }
            testedStates.put(currentState, true);
            queue.addAll(currentState.nextStates(map));
        }
        return -1;
    }   
}