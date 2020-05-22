public static void main(String[] args) {
        Observatory observatory1 = new Observatory("Observatory One");
        Observatory observatory2 = new Observatory("Observatory Two");
        Earthquake quake1a = new Earthquake("Observatory One", 0.1f);
        Earthquake quake1b = new Earthquake("Observatory One", 7.9f);
        Earthquake quake1c = new Earthquake("Observatory One", 8.3f);
        Earthquake quake2a = new Earthquake("Observatory Two", 3.2f);
        Earthquake quake2b = new Earthquake("Observatory Two", 2.9f);
        Earthquake quake2c = new Earthquake("Observatory Two", 4.7f);
        List<Observatory> observatories = new ArrayList<Observatory>();
        observatories.add(observatory1);
        observatories.add(observatory2);
        List<Earthquake> earthquakes = new ArrayList<Earthquake>();
        earthquakes.add(quake1a);
        earthquakes.add(quake1b);
        earthquakes.add(quake1c);
        earthquakes.add(quake2a);
        earthquakes.add(quake2b);
        earthquakes.add(quake2c);
        // Prints "Observatory One"
        System.out.println(findObservatoryWithHighestAverageMagnitude(
                observatories, earthquakes));
    }