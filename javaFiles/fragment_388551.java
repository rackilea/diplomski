List<int[][]> list;
int[][] maze;
int[][] temp = new int[maze.length][];
for(int i = 0; i < maze.length; i++)
{
    temp[i] = new int[maze[i].length];
    System.arraycopy(maze[i], 0, temp[i], 0, maze[i].length);
}
list.add(temp);