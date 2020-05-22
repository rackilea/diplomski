import java.util.*;

    public class Maze { 
        public static void main(String [] args)
        {
            int[][] arr = new int[][] {
                {0,0,0,0,0},
                {1,1,1,1,0},
                {0,0,0,0,0},
                {0,1,1,1,1},
                {0,1,1,1,1},
                {0,0,0,0,0},
            };
            answer(arr);
        }
        public static int answer(int[][] maze) { 
            maze[maze.length-1][maze[0].length -1] = 9;
            State p = getPathBFS(0,0,maze);
            int length = 1;

            while(p.getParent() != null) {
                p = p.getParent();
                length++;
            }
            System.out.println(length);
            return length;
        } 
         private static class State {
            int x;
            int y;
            boolean wallRemoved;

            State parent;

            public State(int x, int y, boolean wallRemoved, State parent) {
                this.x = x;
                this.y = y;
                this.wallRemoved = wallRemoved;
                this.parent = parent;
            }

            public State getParent() {
                return this.parent;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + (wallRemoved ? 1231 : 1237);
                result = prime * result + x;
                result = prime * result + y;
                return result;
            }

            @Override
            public boolean equals(Object obj)  {
                if (this == obj)
                    return true;
                if (obj == null ||getClass() != obj.getClass())
                    return false;
                State other = (State) obj;
                if (wallRemoved != other.wallRemoved)
                    return false;
                if (x != other.x)
                    return false;
                if (y != other.y)
                    return false;
                return true;
            }

      }
      public static Queue<State> q = new LinkedList<>();
      public static HashSet<State> seen = new HashSet<>();

        public static State getPathBFS(int x, int y,int[][] arr) {

            q.add(new State(x,y,false, null));

            while(!q.isEmpty()) {
                State p = q.remove();

                if (arr[p.x][p.y] == 9) {
                    return p;
                }

                tryNext(p,p.x+1,p.y,arr);
                tryNext(p,p.x-1,p.y,arr);
                tryNext(p,p.x,p.y+1,arr);
                tryNext(p,p.x,p.y-1,arr);
            }
            return null;
        }

        public static void tryNext(State p, int x, int y, int[][]arr)  {
            if (x<0 || y<0 || x>=arr.length || y>=arr[x].length)
                return;
            State newState;
            if (arr[x][y] == 0 || arr[x][y]==9)  {
                newState = new State(x, y, p.wallRemoved, p);
            } else if (!p.wallRemoved) {
                newState = new State(x, y, true, p);
            } else {
                return;
            }
            if (seen.add(newState)) {
                q.add(newState);
            }
        }
    }