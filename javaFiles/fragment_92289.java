String myStarWarsName = new String("obi wan kenobi");
            String[] names = myStarWarsName.split(" ");
            String result = new String();
            for(String name : names){
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                result.concat(name).concat(" ");
            }
            myStarWarsName = result.trim();
            //myStarWarsName is now "Obi Wan Kenobi"