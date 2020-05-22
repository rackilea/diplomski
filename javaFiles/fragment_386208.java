int retries = 0;
int NUM_RETRIES = 10;
while (true) // break out below                                                                                                                             
{
    retries++;
    pm.currentTransaction().begin();
    Object obj = pm.getObjectById(getTargetClass(), getKey());
    // Make update to obj                                                                                                                                   
    try
    {
        pm.currentTransaction().commit();
        break;
    }
    catch (JDOCanRetryException ex)
    {
        if (retries == NUM_RETRIES)
        {
            throw ex;
        }
    }
}