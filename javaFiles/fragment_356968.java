public String feedCheck()
{
    MClient client = (MClient) getRequest().getSession().getAttribute(
            AAI_CLIENT);
    List<String> feedNamesFromDB=mFeedManager.getAllFeedNameByClient(client.getClientKey());
    System.out.println(feedName);
    if(feedNamesFromDB.size()>0)
    {
        if(feedNamesFromDB.contains(feedName))
        {
            this.setInputStream(new ByteArrayInputStream(ERROR.getBytes()));
        }
        else
        {
            this.setInputStream(new ByteArrayInputStream(SUCCESS.getBytes()));
        }
    }
    else
    {
        this.setInputStream(new ByteArrayInputStream(SUCCESS.getBytes()));
    }

    return SUCCESS;

}