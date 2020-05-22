while (scanner.hasNextLine())
{
    String line = scanner.nextLine();
    Scanner scan = new Scanner(line);
    String color = "";
    int width=0;

    while(scan.hasNext())
    {
        int x=0;
        int y=0;

        boolean isInt = scan.hasNextInt();
        String next = scan.next();

        if(next.equals("#"))
        {
            scan.nextLine();
            continue;
        }
        else if(isInt && Integer.parseInt(next) < 10)
        {
            width=scan.nextInt();
            color=scan.next();
        }
        else if(!isInt)
        {
            color=next;
        }
        else if(isInt && Integer.parseInt(next) > 10)
        {
            x=scan.nextInt();
            y=scan.nextInt();
        }
        plotter.startLine(color, new Point(x,y));
    }
}