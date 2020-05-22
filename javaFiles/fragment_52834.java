try {
    Double result = Double.parseDouble(string);

    //This is required to check that number is a valid Percentage value
    if(!(result > 0 && result < 100)){
       //You will have to create this custom exception or throw a simple exception
       throw new InvalidPercentageCustomException(result + " is not a valid Percentage");
    }
}
catch(Exception e){
//Do Something
}