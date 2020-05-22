public class Solution
{
    static int [][] arr;
    static int num = 2;
    static int N;
    static String output = "";
    public static void main(String[] args) throws IOException
    {
        int T;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(reader.readLine().trim());
        int i, j, k;

        for(i=0;i<T;i++)
        {
            N = Integer.parseInt(reader.readLine().trim());
            arr = new int[N][N];

            for(j=0;j<N;j++)
            {
                String [] temp = reader.readLine().trim().split(" ");
                for(k=0;k<N;k++)
                {
                    arr[j][k] = Integer.parseInt(temp[k]);
                }
            }