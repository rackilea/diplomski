public static String nominator(String nbrPeople)
{
    BigDecimal nom = new BigDecimal("365") ;
    BigDecimal days = new BigDecimal("365") ;
    int limit = Integer.parseInt(nbrPeople);
    for (int i = 0 ; i < limit ; i++ )
    {
        days = days.subtract(new BigDecimal(i)) ;
        nom = nom.multiply(days) ;
    }
    return  nbrPeople ;
}