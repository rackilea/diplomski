ArrayList<String> listOfPages = session.getAttribute("myVisitedPages");
  if(listOfPages == null) {
       listOfPages = new ArrayList<String>();

       session.setAttribute("myVisitedPages", listOfPages);
   }

   if (Utilities.isFirstVisit(listOfPages, pictureName) == true) {
       Utilities.IncreaseCount(out, pictureName);
       out.println("its worked");
   }