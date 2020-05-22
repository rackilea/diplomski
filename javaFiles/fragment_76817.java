public static void main(String[] args)
{
    String[] tests = 
        {
            "123123",
            "235623",
            "2356238888",
            "88388",
            "883883",
            "23235623238888",
        };

    for(String s : tests)
    {
        List<Byte> in = new ArrayList<>();
        for(String ns : s.split("")) in.add(Byte.parseByte(ns));
        System.out.println(s + " " + longestRepeatingSeq(in));
    }
}