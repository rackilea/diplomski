Object inputDto = ...;
if( inputDto instanceof ICustomerNumber ) {
   //cast to ICustomerNumber, get the value and add predicate for customer number
}
if( inputDto instanceof ICustomerName ) {
   //cast to ICustomerName , get the value and add predicate for customer name
}
if( inputDto instanceof ILoanAmount ) {
   //cast to ILoanAmount , get the value and add predicate for loan amount
}