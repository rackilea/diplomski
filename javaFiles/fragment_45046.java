PhoneAccount[] phoneaccounts = am.getAllAccounts() ;
for( PhoneAccount phoneaccount  : phoneaccounts)
{
 System.out.println(phoneaccount.getTotalBill());
// fetch all the  other properties from phoneaccoun similarly.
}