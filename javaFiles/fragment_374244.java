for (int i = 0; i <= word.length(); i++) {
            HashSet<String> hs=new HashSet<>();
            hs.add(word);
            wordMap.putIfAbsent(word.substring(0, i), hs);
           // wordMap.putIfAbsent(word.substring(0, i), new HashSet<>().add(word));

            System.out.println(wordMap.get(word.substring(0, i)));
         }