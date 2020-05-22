for(Request r : Sys.queue)
{
    {       
        for(Porter p : p_i.porList)
        {

            if(p.p_state.equals("Available"))
            {
                ...
                ...
                Sys.queue.remove(r);
            }
        }
    }
}