private static List<Integer> merge(List<Integer> a , List<Integer> b)
{
    if(a.contains(b.get(0)) || a.contains(b.get(1)))
        return null;

    List<Integer> result = new ArrayList<>(a);

    result.addAll(b);
    Collections.sort(result);

    //check whether the indices from b have been inserted correctly
    //split the sequence into two parts of same length, now the position of b.get(0) 
    //in the first part must be equal to the position of b.get(1) in the second part
    if(result.indexOf(b.get(1)) - result.indexOf(b.get(0)) == result.size() / 2)
        return result;
    else
        return null;
}