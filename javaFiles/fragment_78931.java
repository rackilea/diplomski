if (clientValue.startsWith('(') && clientValue.endsWith(')'))
{
   return new BigDecimal(clientValue.substring(1, clientValue.length() - 1)).negate();
}
else
{
   return new BigDecimal(clientValue);
}