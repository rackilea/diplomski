ArrayList<ArrayList> someArray = new ArrayList<ArrayList>();
for(int x=0 ; x<5 ; x++)
{
    someArray.add(new ArrayList());
    for(int y=0 ; y<5 ; y++)
        someArray.get(x).add(null);
}