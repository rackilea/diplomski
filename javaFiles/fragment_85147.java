Public Feedback getCustomerDetails()
{
   if(noCustomer)
   {
       ..log..etc..
       return new Feedback(null, Feeback.STATUS_NO_CUSTOMER);
   }

   if(some other bad weird condition)
   {
       ..log..etc..
       return new Feedback(null, Feeback.STATUS_BAD_CONDITION);
   }

   CustomerDetails details = getCustomerDetailsFromSomewhere();

   if(details != null)
   {
        return new Feedback(details, Feeback.STATUS_OK);
   }
   else
   {
       ..log..etc..
       return new Feedback(null, Feeback.STATUS_NULL);
   }
}