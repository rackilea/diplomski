void executedInFirstThread() 
{
    synchronized (synchronizedMap)
    {
        for (Key key : synchronizedMap.keySet())
        {
            System.out.println(synchronizedMap.get(key));
        }
    }
}
void executedInSecondThread() 
{
    synchronizedMap.put(someKey, someValue);
}