if (session.getAttribute("recordInsertedSuccessfully") == null )
{
   //proceed with insertion
   //after inserting into the database we should do :
   session.putAttribute("recordInsertedSuccessfully","true");
} else {
   //case of form re-submission
}