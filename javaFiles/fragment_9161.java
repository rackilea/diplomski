import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


public class PlayerSpawning
{
    public static void main(String[] args)
    {
        PlayerSpawning p = new PlayerSpawning();
        p.spawnPlayers();
    }

    private List<Player> players;
    private PlayerMap map;

    PlayerSpawning()
    {
        map = new PlayerMap();
        players = new ArrayList<Player>();

        Player player0 = new Player("player0");
        player0.getCharacter().setPosition(new Point(0,0));
        player0.getCharacter().setCanSpawn(false);
        players.add(player0);

        Player player1 = new Player("player1");
        player1.getCharacter().setCanSpawn(true);
        players.add(player1);
    }

    public void spawnPlayers()
    {
        for (Player player : players)
        {
            if (player.getCharacter().getCanSpawn())
            {
                spawnPlayer(player);
            }
        }
    }

    private void spawnPlayer(Player playerToSpawn)
    {
        System.out.println("Spawning "+playerToSpawn);

        Set<Point> availableSpawnPoints = 
            new LinkedHashSet<Point>(map.getSpawnPoints());
        Set<Point> positionsOfOtherPlayers = 
            new LinkedHashSet<Point>();
        for (Player player : players)
        {
            if (player.getCharacter().getLives() <= 0)
            {
                continue;
            }
            if (player.getCharacter().getCanSpawn())
            {
                continue;
            }
            Point position = player.getCharacter().getPosition();

            System.out.println(
                "Have to consider that "+player+" is at "+position+
                " - this position is no longer available for spawing!");
            positionsOfOtherPlayers.add(position);
            availableSpawnPoints.remove(position);
        }

        Point spawnPoint = computePointWithLargestMinimumDistance(
            availableSpawnPoints, positionsOfOtherPlayers);

        System.out.println("Spawning "+playerToSpawn+" at "+spawnPoint);
        playerToSpawn.getCharacter().spawn(spawnPoint);
    }


    private Point computePointWithLargestMinimumDistance(
        Iterable<? extends Point> points, Set<? extends Point> others)
    {
        System.out.println("Compute point from    "+points);
        System.out.println("that is furthest from "+others);

        double largestMinDistance = Double.NEGATIVE_INFINITY;
        Point result = null;
        for (Point point : points)
        {
            double minDistance = 
                computeMinimumDistance(point, others);
            if (minDistance > largestMinDistance)
            {
                largestMinDistance = minDistance;
                result = point;
            }
        }
        System.out.println(
            "The point that has the largest minimum " +
            "distance "+largestMinDistance+" to any other point is "+result);
        return result;
    }


    private double computeMinimumDistance(
        Point point, Iterable<? extends Point> others)
    {
        double minDistanceSquared = Double.POSITIVE_INFINITY;
        for (Point other : others)
        {
            minDistanceSquared = 
                Math.min(minDistanceSquared, point.distanceSq(other));
        }
        return Math.sqrt(minDistanceSquared);
    }

}


class Player
{
    private String name;
    private Character character = new Character();

    public Player(String name)
    {
        this.name = name;
    }

    public Character getCharacter()
    {
        return character;
    }

    @Override
    public String toString()
    {
        return name;
    }

}
class Character
{
    private Point position = new Point();
    private boolean canSpawn = false;

    public boolean getCanSpawn()
    {
        return canSpawn;
    }

    public void setCanSpawn(boolean canSpawn)
    {
        this.canSpawn = canSpawn;
    }

    public int getLives()
    {
        return 1;
    }

    public Point getPosition()
    {
        return position;
    }

    public void setPosition(Point p)
    {
        position.setLocation(p);
    }

    public void spawn(Point spawnPoint)
    {
        setPosition(spawnPoint);
        canSpawn = false;
    }


}

class PlayerMap
{

    public List<Point> getSpawnPoints()
    {
        return Arrays.asList(
            new Point(0,0),
            new Point(200,0),
            new Point(0, 500),
            new Point(200,500));
    }

}