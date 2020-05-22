for (int i = 0; i < 20; i++){
        System.out.println("Enter word #" + (i+1) +": ");
        words[i] = input.next();
        if (map.containsKey(words[i].charAt(0)))
    {
        map.put(words[i].charAt(0), (int)map.get(words[i].charAt(0))+ 1);
    }
    else
    {
        map.put(words[i].charAt(0), 1);
    }
    }