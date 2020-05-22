@Query(value = "SELECT * FROM(SELECT *,"
        + "(((acos(sin((0.0 * pi()/180)) * sin((latitude*pi()/180)) + "
        + "cos((0.0 * pi()/180)) * cos((latitude*pi()/180)) * "
        + "cos(((0.0 - longitude)*pi()/180))))*180/pi()) * "
        + "60*1.1515*1.609344) as distance FROM college) t WHERE distance <= 30;", 
        nativeQuery = true)