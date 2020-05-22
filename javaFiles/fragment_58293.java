public static void main(String[] args)
{
    int[] shirts = new int[] { 3, 4, 5, 7, 1, 6, 2 };

    Path shortestPath = shirtAlgorithm(shirts);
}


public static class Path
{
    private ArrayList<Integer> path;
    private int[] shirts;

    public Path(ArrayList<Integer> _path_, int[] _shirts_)
    {
        this.path = _path_;
        this.shirts = _shirts_;
    }

    public void setPath(ArrayList<Integer> _path_)
    { this.path = _path_; }

    public ArrayList<Integer> getPath()
    { return this.path; }

    public void setShirts(int[] _shirts_)
    { this.shirts = _shirts_; }

    public int[] getShirts()
    { return this.shirts; }
}




public static Path shirtAlgorithm(int[] shirts)
{
    ArrayList<Path> paths = new ArrayList<>();

    paths.add(new Path(new ArrayList<Integer>(), shirts));

    while (true)
    {
        ArrayList<Path> newpaths = new ArrayList<Path>();

        for (Path curpath : paths)
        {
            for (int operation = 1; operation <= 4; operation++)
            {
                ArrayList<Integer> curnewpath = new ArrayList<Integer>(curpath.getPath());
                curnewpath.add(operation);

                Path newestPath = new Path(
                        curnewpath, 
                        operation(curpath.shirts, operation));

                if (algorithmComplete(newestPath))
                    return newestPath;

                newpaths.add(newestPath);
            }
        }

        paths = newpaths;
    }
}

private static int[] operation(int[] shirts, int operationtype)
{
    int[] newshirts = new int[shirts.length];
    System.arraycopy(shirts, 0, newshirts, 0, shirts.length);
    // logic here
    return newshirts;
}

private static boolean algorithmComplete(Path path)
{
    // true if the shirts are in the right order
}