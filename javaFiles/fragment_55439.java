HashMap<String, Integer> m = new HashMap<String, Integer>(); 
for (Obj o : s)
{
    Integer i = m.get(o.getKey());
    if (i == null)
    {
        i = o.getOcc();
    }
    else
    {
        i += o.getOcc();
    }

    m.put(o.getKey(), i); 
}