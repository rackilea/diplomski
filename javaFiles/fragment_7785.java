listRegion = new List();
 while (inputStream.hasNext()) {
            String data = inputStream.next(); //gets the whole line
            String[] arrayLocations = data.split(",");
            System.out.println(arrayLocations[0]);
            System.out.println(arrayLocations[1]);
            for(String location : arrayLocations)
                 listRegion.add(location);
        }