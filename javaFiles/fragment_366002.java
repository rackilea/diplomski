public class QuickFindUF
{
    //
    // add this so you can run code when your program executes
    //
    public static void main(String[] args)
    {
        QuickFindUF x = new QuickFindUF(10);
        //
        // call your methods on x here
        // e.g.
        // boolean connected = x.connected(2, 3);
        //
    }

    private int[] id;
    public QuickFindUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
    }

    public boolean connected(int p, int q)
    { return id[p] == id[q]; }

    public void union(int p, int q)
    {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++)
            if (id[i] == pid) id[i] = qid;
    }
}