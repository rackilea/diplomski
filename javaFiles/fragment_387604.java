String x = JOptionPane.showInputDialog("X Coordinate", "Enter an x coordinate");
if (x == null || x.isEmpty()) {
    //throw Exception or set x to "0" - I'll set to 0
    x = "0";
}
int xCoord = Integer.parseInt(x);