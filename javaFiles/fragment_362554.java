/**
* You parser method of Character to Integer
*/
public List<Integer> converToIngeter(List resultList){//This should accept your resultSet from your query as List
    List<Integer> toReturn  = new ArrayList<>();

    resultList.stream().forEach((o)->{
        if(Character.isDigit((Character) o)){//(Character) o) is just an insurance that the instance is Character
            toReturn.add(Character.getNumericValue((Character)o));
        }
    });


     /* Or you do some other parsing 
      */
     return toReturn;
}