public ModelAndView approveTimesheet(
    @RequestBody ApproveTimesheet[] timesheets,
    HttpSession session) 
{
  for(int i = 0; i < timesheets.length; i++)
  {
    logger.info(timesheets[i]);
  }
  //...
}