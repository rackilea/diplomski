long LOWER_RANGE = 0; //assign lower range value
 long UPPER_RANGE = 1000000; //assign upper range value
 Random random = new Random();


 long randomValue = LOWER_RANGE + 
                           (long)(random.nextDouble()*(UPPER_RANGE - LOWER_RANGE));