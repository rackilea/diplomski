public static Map<String, List<Earthquake>> mapQuakeToObs(
            List<Observatory> obsList, List<Earthquake> quakes) {

        Map<String, List<Earthquake>> obsAndQuakes =
                new HashMap<String, List<Earthquake>>();
        //Earthquake object contains String "o" to define its assigned observatory
        for(Earthquake quake : quakes) {
            for (Observatory obs : obsList) {

                if (obs.getObsname().equals(quake.getObsname())) {
                    List<Earthquake> quakesMappedToObs = null;
                    // If the map doesn't already contain the key, then put it there
                    if(!obsAndQuakes.containsKey(obs.getObsname())) {
                        quakesMappedToObs = new ArrayList<Earthquake>();
                        obsAndQuakes.put(obs.getObsname(), quakesMappedToObs);
                    } else {
                        quakesMappedToObs = obsAndQuakes.get(obs.getObsname());
                    }
                    quakesMappedToObs.add(quake);
                }
            }
        }
        return obsAndQuakes;
    }