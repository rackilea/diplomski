try{
    if(!matcher.find()){ // If string contains any number/symbols etc...
        throw new Exception("Not a perfect String");
    }
        //This will not be executed if exception occurs
    System.out.println("This will not be executed if exception occurs");

}catch(Exception e){
    System.out.println(e.toString());
}