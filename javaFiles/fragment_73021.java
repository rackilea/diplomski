public void valsInt(String entry){
    if(!entry.trim().isEmpty()){
        try{
            int number = Integer.parseInt(entry);
            setIsTrue(true);
        }catch(NumberFormatException e){
            System.out.println("`"+getUserInputString()+"` IS AN INVALID ENTRY. YOU CAN ONLY ENTER DIGITS FOR THE " + entry);
            setIsTrue(false);
        }
    }else{
        System.out.println("THE ENTRY IS EMPTY");
    }
}