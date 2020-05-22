public Direction getRandomExit(){
        List<Direction> directions = new ArrayList<Direction>(exits.keySet());
        if (directions.size()==0){
            return null;
        }
            Random rand = new Random();
            int randomIndex = rand.nextInt(directions.size());
            return directions.get(randomIndex);

    }