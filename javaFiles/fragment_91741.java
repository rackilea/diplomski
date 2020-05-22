@Test
public void checkAlreadyUsedOrValidHealthDashBoardTokenTest()
{
    <Enter prerequisite codes>
    int flag=0;
    try
    {
        checkAlreadyUsedOrValidHealthDashBoardToken(serviceCode);
    }
    catch(GlobalException ge)
    {
        if(GlobalException Response Type is SERVICE_ALREADY_USED_HEALTH_DASHBOARD_TOKEN)
        {
            falg=1;
        }
        else if(GlobalException Response Type is SERVICE_NOT_VALID_HEALTH_DASHBOARD_TOKEN)
        {
            flag=2;
        }
    }
    finally
    {
        assertEquals(flag,0/1/2);
    }

}