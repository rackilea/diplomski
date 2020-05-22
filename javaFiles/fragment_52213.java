Set<Integer> evenSet = new LinkedHashSet<Integer>();
Set<Integer> oddSet = new LinkedHashSet<Integer>();
f(Line[i] % 2 == 0)
{
    evenSet.add(Line[i]); // add data to a set here instead of string concatenation
}
else
{
    oddSet.add(Line[i]);// add data to a set here instead of string concatenation
}