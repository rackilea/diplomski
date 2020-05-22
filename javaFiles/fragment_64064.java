Set<Integer> hs=new HashSet<Integer>();
Set<Integer> duplicate= new HashSet<Integer>();
for(int ar:arrays)
{
    if(!hs.add(ar))
    {
        duplicate.add(ar); 
    }           
}