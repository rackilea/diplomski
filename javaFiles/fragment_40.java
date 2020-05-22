void executedInFirstThread() 
{
    synchronizedMap.put(someKey, someValue);
}
void executedInSecondThread() 
{
    synchronizedMap.remove(someOtherKey);
}