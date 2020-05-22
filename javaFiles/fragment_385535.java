...
int []familyCount = null
if (null == families) 
{
    // create array for
    families = new String[] { personLastName };
    taxes = new double[] { personTax };
    familyCount = new int[] {1};

} 
else 
{
    boolean familyExists = false;

    // check existing families
    for (int i = 0; i < families.length; i++) 
    {
        if (personLastName.equals(families[i])) 
        {
            // add personTax to family owed taxes
          taxes[i] += personTax;  

          familyCount[i] ++;

            familyExists = true;
            break;
        }
    }
    if (!familyExists) 
    {
        // Extend arrays to put new family
        // create temp arrays with size+1

        String[] tmpFamilies = new String[families.length + 1];
        double[] tmpTaxes = new double[taxes.length + 1];
        int[] tmpFamilyCount = new int[familyCount.length+1];


        ...
        System.arraycopy(familyCount, 0, tmpFamilyCount, 0, familyCount.length);

        // set new last elements data 
        ...
        tmpFamilyCount[tmpFamilyCount.length-1] = 1;

        // replace families and taxes with newly created tmp arrays 
        ...
        familyCount = tmpFamilyCount;
    }
}//else