public class Board {
public HashMap<String, String> spelMap = new HashMap<String, String>();

Board() {
    spelMap.put("A", ".");
    spelMap.put("B", ".");
    spelMap.put("C", ".");
    spelMap.put("D", ".");
    spelMap.put("E", ".");
    spelMap.put("F", ".");
    spelMap.put("G", ".");
    spelMap.put("H", ".");
    spelMap.put("I", ".");
    spelMap.put("J", ".");
    spelMap.put("K", ".");
    spelMap.put("L", ".");
    spelMap.put("M", ".");
    spelMap.put("N", ".");
    spelMap.put("O", ".");
    spelMap.put("P", ".");
    spelMap.put("Q", ".");
    spelMap.put("R", ".");
    spelMap.put("S", ".");
    spelMap.put("T", ".");
    spelMap.put("U", ".");
    spelMap.put("V", ".");
    spelMap.put("W", ".");
    spelMap.put("X", ".");

}

public String[] postMethod() {
    return new String[]
            {
                    "" + spelMap.get("A") + "-----------" + spelMap.get("B") + "-----------" + spelMap.get("C") + "",
                    "|           |           |",
                    "|   " + spelMap.get("D") + "-------" + spelMap.get("E") + "-------" + spelMap.get("F") + "   |",
                    "|   |       |       |   |",
                    "|   |   " + spelMap.get("G") + "---" + spelMap.get("H") + "---" + spelMap.get("I") + "   |   |",
                    "|   |   |       |   |   |",
                    "" + spelMap.get("J") + "---" + spelMap.get("K") + "---" + spelMap.get("L") + "       " + spelMap.get("M") + "---" + spelMap.get("N") + "---" + spelMap.get("O") + "",
                    "|   |   |       |   |   |",
                    "|   |   " + spelMap.get("P") + "---" + spelMap.get("Q") + "---" + spelMap.get("R") + "   |   |",
                    "|   |       |       |   |",
                    "|   " + spelMap.get("S") + "-------" + spelMap.get("T") + "-------" + spelMap.get("U") + "   |",
                    "|           |           |",
                    "" + spelMap.get("V") + "-----------" + spelMap.get("W") + "-----------" + spelMap.get("X") + ""
            };
    }

}