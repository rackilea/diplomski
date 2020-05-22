int NameCount[]=new int[TOTAL_NUMBER_OF_DISTINCT_NAMES];//array should be initialized to 0
while(token.hasNext())
{
    String name = token.next();
    NameCount[INDEX_ASSOCIATED_TO_NAME]++;
}