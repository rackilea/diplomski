public void two(final BeanForm[] captureddata)
{
  int count = 0;

  for (BeanForm form : captureddata) 
  {
    if (form.getCyclicType() != null) 
    {
      logger.info(count + " The Cyclic Type is"+ form.getCyclicType().value());
    }

    if (form.getTicketType() != null) 
    {
      logger.info(count + " The Ticket Type is"+ form.getTicketType().value());
    }

    count++;
  }
}