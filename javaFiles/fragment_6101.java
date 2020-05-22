public class Dungeon
{
    public static final String LINEBREAK = System.getProperty("line.separator");

    public static void main(final String[] args)
    {
        final int[][] dungeon = new int[10][10];
        System.out.println("Dungeon begins : ");
        final StringBuffer buffer = new StringBuffer();
        for (int y = 0; y < dungeon.length; y++)
        {

            for (int x = 0; x < dungeon[0].length; x++)
            {
                buffer.append(dungeon[y][x]);
            }
            buffer.append(LINEBREAK);
        }

        System.err.println(buffer.toString());
        System.out.println("Dungeon finished : ");
    }
}