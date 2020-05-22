for(int i=2;i<6;i++)
{
    al.add(i);
    if(i%2!=0)
    {
        aal.add(new ArrayList<>(al));
        al.clear();
    }
}