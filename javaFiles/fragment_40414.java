public static void intersection (ArrayList<Integer>s1, ArrayList<Integer>s2)
{
    HashSet <Integer> intersect = new HashSet<Integer>();

    for (int i=0; i<s1.size(); i++)
    {
        if (s2.contains(s1.get(i))) intersect.add(s1.get(i));

    }

    System.out.println("intersection - "+ intersect);

}