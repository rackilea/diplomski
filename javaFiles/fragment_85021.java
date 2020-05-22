public static void main(String... args){     
    Set<String> set = new TreeSet<String>();
    String key = "aehrt";

    //S1 = c*S0 ∪ {c} ∪ S0
    for(int z = 0; z < key.length();z++) {
        Set<String> temp = new HashSet<String>();
        char c = key.charAt(z);        

        for(String str: set)
            temp.add(str + c); // ∪ c*S0
        set.add(c+"");         // ∪ {c}
        set.addAll(temp);      // ∪ S0
    }

    System.out.println(set);
}

output: [a, ae, aeh, aehr, aehrt, aeht, aer, aert, aet, ah, ahr, ahrt, aht, ar, art,
         at, e, eh, ehr, ehrt, eht, er, ert, et, h, hr, hrt, ht, r, rt, t]