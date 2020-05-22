if (numberOfWords <= 25)
{
    textCost = TEXT_BASE_FEE + (TEXT_FLAT_FEE * numberOfWords);
}
else if (numberOfWords <= 35)
{
    textCost = TEXT_BASE_FEE + (TEXT_FLAT_FEE * 25) + (numberOfWords - 25) * 
               LESS_OR_EQUAL_THAN_THIRTYFIVE;
}
else // Note - no condition.
{
    textCost = numberOfWords * MORE_THAN_THIRTYFIVE;
}