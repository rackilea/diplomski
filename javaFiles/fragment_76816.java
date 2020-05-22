static List<Byte> longestRepeatingSeq(List<Byte> in)
{
    int n = in.size();
    Set<List<Byte>> seen = new HashSet<>();
    List<Byte> max = Collections.<Byte> emptyList();
    for (int i=0; i<n; i++)
    {
        for (int j =i+max.size()+1; j<=n && j<=i +n/2; j++)
        {
            if (j == n || in.get(j) != in.get(j - 1))
            {
                List<Byte> sub = in.subList(i, j);
                if (seen.contains(sub))
                {
                    if (sub.size() > max.size())
                    {
                        max = sub;
                    }
                } 
                else
                {
                    seen.add(sub);
                }
            }
        }
    }
    return max;
}