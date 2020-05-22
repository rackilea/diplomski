public static ArrayList<String>iterate(){
    ArrayList<String> list = new ArrayList<String>();
    for(int i=0;i<114;i++){
        String toAdd = String.valueOf(i);    

        if (isOdd(i)){
            toAdd += ", Is odd";
        }
        if(isDivisibleBy5(i)){
            toAdd += ", hi five";
        }
        if(isDivisbleBy7(i)){
            toAdd += ", wow";
        }
        if (isPrime(i)){
            toAdd += ", prime";
        }

        list.add(toAdd);
    }

    for(String elem:list)
        System.out.println(elem);

    return list;    
}