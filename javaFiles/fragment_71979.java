HashMap<Integer, String> map = new HashMap<>();

        for (String card : cardsList)
        {
            if(card.equals("Ace")) // or whatever string to be mapped to value 10
                map.put(10, card);
            if(card.equals("King"))
                map.put(9, card);

        }