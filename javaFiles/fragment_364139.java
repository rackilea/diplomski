if(o1.getUseDate() == null && o2.getUseDate() == null)
    return 0; //They are both null, both equal
if(o1.getUseDate() == null && o2.getUseDate() != null)
    return -1; // The first is null and the second is not, return the first as lower than the second
if(o1.getUseDate() != null && o2.getUseDate() == null)
    return 1; //The first is not null and the second is, return the first as higher than the second
else
    return o1.getUseDate().compare(o2.getUseDate()); //Return the actual comparison