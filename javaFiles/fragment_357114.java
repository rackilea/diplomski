listOfEvents.stream() //stream the events
            .map(Event::getUnavailableLocalizations) //for each event, get the map
            .map(Map::values) //get the values
            .flatMap(Collection::stream) //flatMap to merge all the values into one stream
            .distinct() //remove duplicates
            .count();   //count