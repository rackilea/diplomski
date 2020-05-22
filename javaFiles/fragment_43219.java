while(abc){
    try{
        System.out.println("do you like me?")
        bucket = keys.nextLine(); *//user types in some string..*

        if(bucket.equals("yes")){
            System.out.println("Yay! I love you too! :P");
        }
        else {
           abc = false;
        }
        System.out.println("How much money do you have on you?");
        numbers = keys.nextInt(); *//user types in **ex**. "no"*
        System.out.println(numbers);
    }
    catch(Exception a){
        abc == true;
    }
    finally{
        if(abc == false){
            keys.close;
        }
    }
}