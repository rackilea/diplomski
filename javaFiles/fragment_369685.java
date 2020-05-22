public class actionClass {
    public static void cmdCenter(String cmdIF, int x, int y) {
        if(cmdIF.equalsIgnoreCase("NORTH") || cmdIF.equalsIgnoreCase("GO NORTH")) { out.println("GO NORTH"); x++; }
        else if(cmdIF.equalsIgnoreCase("EAST") || cmdIF.equalsIgnoreCase("GO EAST")) { out.println("GO EAST"); y++; }
        else if(cmdIF.equalsIgnoreCase("SOUTH") || cmdIF.equalsIgnoreCase("GO SOUTH")) { out.println("GO SOUTH"); x--; }
        else if(cmdIF.equalsIgnoreCase("WEST") || cmdIF.equalsIgnoreCase("GO WEST")) { out.println("GO WEST"); y--; }
        else { System.out.println("You can't do that."); }

    }
}