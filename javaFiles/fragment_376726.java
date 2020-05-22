public void two(final BeanForm[] captureddata)
{
  for (int i=0; i<captureddata.length; i++)
  {
    BeanForm form = capturedata[i];

    if (form.getCyclicType() != null) 
    {
      logger.info(i+ " The Cyclic Type is"+ form.getCyclicType().value());
    }

    if (form.getTicketType() != null) 
    {
      logger.info(i+ " The Ticket Type is"+ form.getTicketType().value());
    }
  }
}