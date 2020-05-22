public boolean doesPhoneNumberMatchThisInput(final String input)
{
   String formattedInput;
   String formattedCustomerPhoneNumber = npa + nxx + serviceNumber;

   formattedInput = ... strip all non-digits from input.

   return StringUtils.equals(formattedCustomerPhoneNumber, formattedInput);
}