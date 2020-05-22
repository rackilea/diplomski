public String format(LoggingEvent event) {
   String log = super.format(event);
   /*
   Now you just have to replace with regex all occurences of %i or 
   any mark you would like to use as mark to represent Thread ID 
   with Thread ID value.
   Only thing you have to be sure to not use any mark as your Thread ID
   that already is defined by PatterParser class
   */
   return log.replaceAll("%i", someThreadID);
}