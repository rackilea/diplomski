boolean have_received_stop_event = false;
while (!have_received_stop_event)
{
    for(some event)
    {
        if(stop-event)
        {
            have_received_stop_event = true;
            break;
        }

        if(some event does something i want to capture)
        {
            threadPool.submit()     
        }
    }
}