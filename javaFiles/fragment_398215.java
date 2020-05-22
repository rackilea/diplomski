//Collect all Number types to ints
List<Integer> output1 = list.stream().
    filter(val -> !(val instanceof String)).//filter non-String types
    map(val -> ((Number)val).floatValue()).//convert to Number & get float value
    map(val -> (int)Math.round(val)).//apply Math.round
    collect(Collectors.toList());//collect as List

//Collect all String types to int
List<Integer> output2 = list.stream().
      filter(val -> (val instanceof String)).//filter String types
       map(val -> (((String)val).length())).//get String lengths
       collect(Collectors.toList());//collect as List

//Now, merge both the lists
output2.addAll(output1);