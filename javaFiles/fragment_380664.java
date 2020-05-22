public class File1 implements Comparable<File1>
{
    int dist, nod;

    public int compareTo(File1 f)
    {
        return Integer.compare(dist, f.dist);
    }
}