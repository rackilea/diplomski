public class ConsoleLog {
private static Color c = Color.WHITE;
public static Color getC() {
    return c;
}

public static void setC(Color c) {
    ConsoleLog.c = c;
}

private static int pos;
private static List<String[]> logs;
private static List<Point>linesPos = new ArrayList<Point>();
private static Rectangle r = Main.Main.screenSize;
public static void log(List <String[]> logs, Graphics g) {
    g.setColor(c);
    ConsoleLog.logs = logs;
    splitConsole(g);
}

public static void splitConsole(Graphics g){
    pos = 0;
    for(int i = 0; i < (r.height / 2) / 10 - 10; i++) {
        linesPos.add(new Point(10, (i * (r.height / (50 + 3) + 5) + 15)));
    }
    for(int i = 0; i < logs.size(); i++) {
        for(int ie = 0; ie < logs.get(i).length || pos < logs.get(i).length; ie++) {
            g.drawString(logs.get(i)[ie], linesPos.get(pos).x, linesPos.get(pos).y);
            pos++;
        }
    }
}