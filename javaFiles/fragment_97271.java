import java.io.BufferedReader;
    import java.io.DataInputStream;
    import java.io.FileInputStream;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.List;

public class BattingOrder
{
    String game_ID;
    String team_ID;
    String player_ID;
    String position;
    String battingOrder;
    String subOrder;

    public BattingOrder(String game, String team, String player, String place, String batter, String sub) {
        game_ID = game;
        team_ID = team;
        player_ID = player;
        position = place;
        battingOrder = batter;
        subOrder = sub;
    }

    @Override
    public String toString() 
    {
        return game_ID + "," + team_ID + "," + player_ID + "," + position + "," + battingOrder;
    }

    public static void main(String[] args) throws IOException 
    {
        FileInputStream fstream = new FileInputStream("BatterInfo.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String delims = "[,]";
        List<BattingOrder> battingOrders = new ArrayList<BattingOrder>();
        for (String line; (line = br.readLine()) != null;) 
        {
            String[] parsedData = line.split(delims);
            battingOrders.add(new BattingOrder(parsedData[0], parsedData[1], parsedData[2], parsedData[3], parsedData[4], parsedData[5]));
        }
        br.close();

        System.out.println("Unordered");
        for (BattingOrder order : battingOrders) 
        {
            System.out.println(order);
        }

        Collections.sort(battingOrders ,new Comparator<BattingOrder>(){
        @Override
        public int compare(BattingOrder one, BattingOrder two) 
        {
            if(one.battingOrder.equals(two.battingOrder))
            {
                Integer subOrderOne = Integer.parseInt(one.subOrder);
                Integer subOrderTwo = Integer.parseInt(two.subOrder);

                return subOrderOne.compareTo(subOrderTwo);
            }
            Integer orderOne = Integer.parseInt(one.battingOrder);
            Integer orderTwo = Integer.parseInt(two.battingOrder);

            return orderOne.compareTo(orderTwo);
           }
       });

        System.out.println("Ordered");
        for (BattingOrder order : battingOrders) 
        {
            System.out.println(order);
        }

        List<BattingOrder> toDelete = new ArrayList<BattingOrder>();
        for (BattingOrder one : battingOrders) 
        {
            for (BattingOrder two : battingOrders) 
            {
                if(one.battingOrder.equals(two.battingOrder))
                {
                    Integer subOrderOne = Integer.parseInt(one.subOrder);
                    Integer subOrderTwo = Integer.parseInt(two.subOrder);
                    if(subOrderOne < subOrderTwo)
                    {
                        toDelete.add(one);
                    }
                    else if(subOrderOne > subOrderTwo)
                    {
                        toDelete.add(two);
                    }
                }
            }
        }
        battingOrders.removeAll(toDelete);
        System.out.println("Final");
        for (BattingOrder order : battingOrders) 
        {
            System.out.println(order);
        }
    }
}