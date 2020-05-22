<%    
MessageResources mr = MessageResources.getMessageResources("ABC");
Locale locale = (Locale) session.getAttribute(Globals.LOCALE_KEY);

person.setName("John Smith");
person.setOccupation(mr.getMessage(locale, "Chef"));
%>