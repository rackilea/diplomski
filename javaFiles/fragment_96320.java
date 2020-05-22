public static void countChar(char[] abc, char x){
    Map<Character, Integer> map = new HashMap<>();

    for(char c: abc){
        if(map.containsKey(c))
            map.put(c,map.get(c)+1);
        else
            map.put(c,1);
    }

    if(map.get(x)!=null){
        int count = map.get(x);
        System.out.println(x + " exists " + count + " times in char array!");
        for(char c: map.keySet()){
            if(map.get(c)>count)
                System.out.println(c);
        }
    }else{
        System.out.println(x + " does not exist in char array!");
    }
}