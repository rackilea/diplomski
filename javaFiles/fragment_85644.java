ArrayList<Integer> ratings = new ArrayList<Integer>(); 
            JsonValue collect = jsonSong.get("ratings"); 
            JsonArray rate = collect.asArray();
            for(int i=0; i<rate.size(); i++){
                ratings.add(rate.get(i).asInt());
            }