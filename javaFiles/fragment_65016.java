if( isThread1 )
{
    for( ... )
    {
        while( !toggle )
        {
            Thread.sleep(100);
        }
        // Do your stuff here
        toggle = false;
    }
}
else
{
    for( ... )
    {
        while( toggle )
        {
            Thread.sleep(100);
        }
        // Do you stuff here
        toggle = true;
    }
}