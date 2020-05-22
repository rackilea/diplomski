public void IHateToTellPeopleMyMethodName(final String[] args)
{
    try
    {
        fillParameters(args);
    }
    catch (ArgumentException e)
    {
        logger.error(e.getMessage(), e);
        return;
    }
}